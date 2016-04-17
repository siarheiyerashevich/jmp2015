//var movieResponse;
//$(document).ready(function() {
//    $('#userName').blur(function() {
//        $.ajax({
//            url : 'GetUserServlet',
//            data : {
//                selectedDate : $('#selectedDate').val()
//            },
//            success : function(responseText) {
//                $('#movieResponse').text(responseText);
//            }
//        });
//    });
//});
//
//function sendInfo(selectedDate)
//{
//    $.ajax({
//        url : 'GetMovie',
//        data : {
//            selectedDate : selectedDate
//        },
//        success : function(responseText) {
//            movieResponse = responseText;
//        }
//    });
//}