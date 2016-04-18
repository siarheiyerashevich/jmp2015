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
function buyTicket(ticketInfo)
{
    $.ajax({
        type: "POST",
        url : 'buyTicket',
        data : {
            ticketInfo : ticketInfo,
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            place: $('#place').val()
        },
        success : function(responseText) {
            $('#buyTicketResponse').html(responseText);;
        }
    });
}