using System.Data;
using System.Linq;
using System.Threading.Tasks;
using AspNetCoreHero.ToastNotification.Abstractions;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebShop.Models;
namespace WebShop.Areas.Admin.Controllers
{
    [Area("Admin")]
    [Authorize(Roles = "Admin")]
    public class AdminRolesController : Controller
    {
        private readonly dbMarketsContext _context;
        public INotyfService _notyfService { get; }
        public AdminRolesController(dbMarketsContext context, INotyfService notyfService)
        {
            _context = context;
            _notyfService = notyfService;
        }
        public async Task<IActionResult> Index()
        {
            return View(await _context.Roles.ToListAsync());
        }
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null) return NotFound();
            var role = await _context.Roles.FirstOrDefaultAsync(m => m.RoleId == id);
            if (role == null) return NotFound();
            return View(role);
        }
        public IActionResult Create()
        {
            return View();
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("RoleId,RoleName,Description")] Role role)
        {
            if (ModelState.IsValid)
            {
                while (true)
                {
                    try
                    {
                        if (RoleExists(role.RoleName))
                        {
                            _notyfService.Error("Quyền truy cập đã tồn tại");
                            break;
                        }
                        else
                        {
                            _context.Add(role);
                            await _context.SaveChangesAsync();
                            _notyfService.Success("Tạo mới quyền truy cập thành công");
                        }
                    }
                    catch (DbUpdateConcurrencyException) { 
                        throw;
                    }
                    return RedirectToAction(nameof(Index));
                }
            }
            return View(role);
        }
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null) return NotFound();
            var role = await _context.Roles.FindAsync(id);
            if (role == null) return NotFound();
            return View(role);
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("RoleId,RoleName,Description")] Role role)
		{
			if (id != role.RoleId) return NotFound();
			if (ModelState.IsValid)
			{
                while (true)
                {
                    try
                    {
						if (RoleExistsId(id, role.RoleName))
						{
							_context.Update(role);
							await _context.SaveChangesAsync();
							_notyfService.Success("Cập nhật thành công");
                        }
                        else
                        {
							if (RoleExists(role.RoleName))
							{
								_notyfService.Error("Quyền truy cập đã tồn tại");
								break;
							}
							else
							{
								_context.Update(role);
								await _context.SaveChangesAsync();
								_notyfService.Success("Cập nhật thành công");
							}
						}
					}
                    catch (DbUpdateConcurrencyException)
                    {
                        throw;
                    }
                    return RedirectToAction(nameof(Index));
                }
			}
			return View(role);
		}
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null) return NotFound();
            var role = await _context.Roles.FirstOrDefaultAsync(m => m.RoleId == id);
            if (role == null) return NotFound();
            return View(role);
        }
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var role = await _context.Roles.FindAsync(id);
            _context.Roles.Remove(role);
            await _context.SaveChangesAsync();
            _notyfService.Success("Xóa quyền truy cập thành công");
            return RedirectToAction(nameof(Index));
        }
        private bool RoleExists(string name)
        {
            return _context.Roles.Any(e => e.RoleName == name);
        }
		private bool RoleExistsId(int id, string name)
		{
			return _context.Roles.Where(x => x.RoleId == id).Any(x=>x.RoleName==name);
		}
	}
}
