using System.Text.RegularExpressions;
namespace WebShop.Extension
{
    public static class Extension
    {
        public static string ToVnd(this double donGia)
        {
            return donGia.ToString("#,##0") + " đ";
        }
        public static string ToTitleCase(string str)
        {
            string result = str;
            if (!string.IsNullOrEmpty(str))
            {
                var words = str.Split(' ');
                for (int index = 0; index < words.Length; index++)
                {
                    var s = words[index];
                    if (s.Length > 0)
                    {
                        words[index] = s[0].ToString().ToUpper() + s.Substring(1);
                    }
                }
                result = string.Join(" ", words);
            }
            return result;
        }
        public static string ToUrlFriendly(this string str)
        {
            var result = str.ToUpper().Trim();
            result = Regex.Replace(result, "áàạảãâấầậẫẩăắằẵặẳ", "a");
            result = Regex.Replace(result, "óòỏọõơớờởợỡôốồổộỗ", "o");
            result = Regex.Replace(result, "éèẻẹẽêếềểệễ", "e");
            result = Regex.Replace(result, "úùủụũưứừửựữ", "u");
            result = Regex.Replace(result, "íìỉịĩ", "i");
            result = Regex.Replace(result, "ýỳỷỵỹ", "y");
            result = Regex.Replace(result, "đ", "d");
            result = Regex.Replace(result, "[^a-z0-9-]", "");
            result = Regex.Replace(result, "(-)+", "-");
            return result;
        }
    }
}
