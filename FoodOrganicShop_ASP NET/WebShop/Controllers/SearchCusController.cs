using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebShop.Models;
using WebShop.ModelViews;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebShop.Controllers
{
	public class SearchCusController : Controller
	{
		private readonly dbMarketsContext _context;

		public SearchCusController(dbMarketsContext context)
		{
			_context = context;
		}



		[HttpPost]
		[Route("/SearchCus/FindCusProduct/",Name ="ss")]		
		
			public IActionResult FindCusProduct(string keyword)
			{
				List<Product> ls = new List<Product>();
				if (string.IsNullOrEmpty(keyword) || keyword.Length < 1)
				{
					return PartialView("ListProductsCusSearchPartial", null);
				}
				ls = _context.Products.AsNoTracking()
									  .Where(x => x.ProductName.Contains(keyword))
									  .OrderByDescending(x => x.ProductName)
									  .ToList();
				if (ls == null)
				{
					return PartialView("ListProductsCusSearchPartial", null);
				}
				else
				{
					return PartialView("ListProductsCusSearchPartial", ls);
				}
			}

		}
	
}
