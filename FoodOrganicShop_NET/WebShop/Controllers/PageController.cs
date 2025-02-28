﻿using System.Linq;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebShop.Models;
namespace WebShop.Controllers
{
    public class PageController : Controller
    {
        private readonly dbMarketsContext _context;
        public PageController(dbMarketsContext context)
        {
            _context = context;
        }
        [Route("/page/{Alias}", Name = "PageDetails")]
        public IActionResult Details(string Alias)
        {
            if (string.IsNullOrEmpty(Alias)) return RedirectToAction("Index","Home");
            var page = _context.Pages.AsNoTracking().SingleOrDefault(x => x.Alias == Alias);
            if (page == null) return RedirectToAction("Index","Home");
            return View(page);
        }
    }
}
