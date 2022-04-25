using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System;
using System.Diagnostics;

namespace RubixWeb.Pages
{
    public class verificationModel : PageModel
    {
        public void OnGet()
        {
        }

        public IActionResult OnPost()
        {
            var di = Request.Form["DID"];
            var str = Request.Form["name"] + Request.Form["date"] + Request.Form["Adhaar Number"];
            var p = new Process();
            p.StartInfo.FileName = "bash";
            p.StartInfo.RedirectStandardInput = true;
            p.StartInfo.RedirectStandardOutput = true;
            p.Start();
            p.StandardInput.WriteLine("dir");
            p.StandardInput.WriteLine("cd ~");
            p.StandardInput.WriteLine("java -jar rubix.jar");
            p.StandardInput.WriteLine("/home/bishnoitejaswi/icon.png");
            p.StandardInput.WriteLine("1");
            p.StandardInput.WriteLine(str);
            for (int i = 0; i < 11; i++)
            {
                p.StandardOutput.ReadLine();
            }

            var s = p.StandardOutput.ReadLine();
            Console.WriteLine(s);
            if (di == s)
            {
                return Redirect("/Verified");
            }
            else
            {
                return Redirect("/ValFail");
            }
        }
    }
}
