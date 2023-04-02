@section Scripts{
    <script>
        $(document).ready(function () {
            $("#keyword").keyup(function () {
                var strkeyword = $('#keyword').val();
                console.log(strkeyword);
                $.ajax({
                    url: '/SearchCus/FindCusProduct/',
                    datatype: "json",
                    type: "POST",
                    data: { keyword: strkeyword },
                    async: true,
                    success: function (results) {
                        $("#records_table").html("");
                        $("#records_table").html(results);
                    },
                    error: function (xhr) {
                        alert('error');
                    }
                });
            });
        });
    </script>

}