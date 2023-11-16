using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebShop.Models;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebShop.Areas.Admin.Controllerst
{
	[Area("Admin")]
	public class SearchController : Controller
	{
		private readonly dbMarketsContext _context;

		public SearchController(dbMarketsContext context)
		{
			_context = context;
		}

		[HttpPost]
		public IActionResult FindProduct(string keyword)
		{
			List<Product> ls = new List<Product>();
			if (string.IsNullOrEmpty(keyword) || keyword.Length < 1)
			{
				ls = _context.Products.AsNoTracking()
									  .Include(a => a.Cat)
									  .OrderByDescending(x => x.ProductName)
									  .Take(10)
									  .ToList();
				return PartialView("ListProductsSearchPartial", ls);
			}
			else
			{

				ls = _context.Products.AsNoTracking()
									  .Include(a => a.Cat)
									  .Where(x => x.ProductName.Contains(keyword))
									  .OrderByDescending(x => x.ProductName)
									  .Take(10)
									  .ToList();
				if (ls == null)
				{
					return PartialView("ListProductsSearchPartial", null);
				}
				else
				{
					return PartialView("ListProductsSearchPartial", ls);
				}
			}
		}
		public string NonUnicode(string text)
		{
			string[] arr1 = new string[] { "á", "à", "ả", "ã", "ạ", "â", "ấ", "ầ", "ẩ", "ẫ", "ậ", "ă", "ắ", "ằ", "ẳ", "ẵ", "ặ",
	"đ",
	"é","è","ẻ","ẽ","ẹ","ê","ế","ề","ể","ễ","ệ",
	"í","ì","ỉ","ĩ","ị",
	"ó","ò","ỏ","õ","ọ","ô","ố","ồ","ổ","ỗ","ộ","ơ","ớ","ờ","ở","ỡ","ợ",
	"ú","ù","ủ","ũ","ụ","ư","ứ","ừ","ử","ữ","ự",
	"ý","ỳ","ỷ","ỹ","ỵ",};
			string[] arr2 = new string[] { "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a",
	"d",
	"e","e","e","e","e","e","e","e","e","e","e",
	"i","i","i","i","i",
	"o","o","o","o","o","o","o","o","o","o","o","o","o","o","o","o","o",
	"u","u","u","u","u","u","u","u","u","u","u",
	"y","y","y","y","y",};
			for (int i = 0; i < arr1.Length; i++)
			{
				text = text.Replace(arr1[i], arr2[i]);
				text = text.Replace(arr1[i].ToUpper(), arr2[i].ToUpper());
			}
			return text;
		}
	}
}
