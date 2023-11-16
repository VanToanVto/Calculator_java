using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
namespace WebShop.Areas.Admin.Controllers
{
    [Area("Admin")]
    [Route("Admin", Name = "AdminIndex")]
    [Authorize(Roles = "Admin")]
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
