using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using PagedList.Core;
using WebShop.Models;
namespace WebShop.Controllers
{
    public class ProductController : Controller
    {
        private readonly dbMarketsContext _context;
        public ProductController(dbMarketsContext context)
        {
            _context = context;
        }
        [Route("Home/Product", Name = ("ShopProduct"))]
        public IActionResult Index(int? page,int CatID=0)
        {
            try
            {
                var pageNumber = page == null || page <= 0 ? 1 : page.Value;
                var pageSize = 10;
                List<Product> lsProducts = new List<Product>();
                if (CatID != 0)
                {
                    lsProducts = _context.Products.AsNoTracking().Where(x => x.CatId == CatID).Include(x => x.Cat)
                    .OrderBy(x => x.ProductId).ToList();
                }
                else
                {
                    lsProducts = _context.Products.AsNoTracking().Include(x => x.Cat).OrderBy(x => x.ProductId).ToList();
                }
                PagedList<Product> models = new PagedList<Product>(lsProducts.AsQueryable(), pageNumber, pageSize);
                ViewData["DanhMuc"] = new SelectList(_context.Categories, "CatId", "CatName");
                ViewBag.CurrentCateID = CatID;
                ViewBag.CurrentPage = pageNumber;
                return View(models);
            }
            catch
            {
                return RedirectToAction("Index", "Home");
            }
        }
        [Route("Home/Product/Filtter", Name = ("ShopProuct"))]
        public IActionResult Filtter(int CatID = 0)
        {
            var url = $"/Home/Product?CatID={CatID}";
            if (CatID == 0) url = $"/Home/Product";
            return Json(new { status = "success", redirectUrl = url });
        }
        [Route("/DanhMuc/{Alias}", Name = ("ListProduct"))]
        public IActionResult List(string Alias, int page = 1)
        {
            try
            {
                var pageSize = 10;
                var danhmuc = _context.Categories.AsNoTracking().SingleOrDefault(x => x.Alias == Alias);
                var lsTinDangs = _context.Products.AsNoTracking().Where(x => x.CatId == danhmuc.CatId)
                    .OrderByDescending(x => x.DateCreated);
                PagedList<Product> models = new PagedList<Product>(lsTinDangs, page, pageSize);
				ViewData["DanhMuc"] = new SelectList(_context.Categories, "CatId", "CatName");
				ViewBag.CurrentPage = page;
                ViewBag.CurrentCat = danhmuc;
                return View(models);
            }
            catch
            {
                return RedirectToAction("Index", "Home");
            }
        }
        [Route("/Products/{Alias}-{id}", Name = ("ProductDetails"))]
        public IActionResult Details(int id)
        {
            try
            {
                var product = _context.Products.Include(x => x.Cat).FirstOrDefault(x => x.ProductId == id);
                if (product == null) return RedirectToAction("Index");
                var lsProduct = _context.Products.AsNoTracking()
                    .Where(x => x.CatId == product.CatId && x.ProductId != id && x.Active == true).Take(4)
                    .OrderByDescending(x => x.DateCreated).ToList();
                ViewBag.SanPham = lsProduct;
                return View(product);
            }
            catch
            {
                return RedirectToAction("Index", "Home");
            }
        }
    }
}
