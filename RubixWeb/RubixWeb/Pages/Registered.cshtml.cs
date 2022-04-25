using Microsoft.AspNetCore.Mvc;
using System;
using System.Diagnostics;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace RubixWeb.Pages
{
    public class RegisteredModel : PageModel
    {
        public void OnGet()
        {
            Process p = new Process();
            p.StartInfo.FileName = "bash";
            p.StartInfo.RedirectStandardInput = true;
            p.StartInfo.RedirectStandardOutput = true;
            p.Start();
            string command = "ipfs get -o " + "~/ipfs " + HttpContext.Request.Query["did"];
            p.StandardInput.WriteLine(command);
            command = "mv -f ~/ipfs/" + HttpContext.Request.Query["did"] + " wwwroot/did.png";
            p.StandardInput.WriteLine(command);
        }
    }
}
