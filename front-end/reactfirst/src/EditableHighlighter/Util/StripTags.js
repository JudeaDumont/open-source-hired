export default function stripTags(html)
{
   var div = document.createElement("div");
   div.innerHTML = html;
   return div.textContent || div.innerText || "";
}