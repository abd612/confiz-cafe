using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace Confiz_Cafe_UI.Controllers
{
    public class BillController : Controller
    {
        public IActionResult CreateBill()
        {
            return View();
        }
    }
}