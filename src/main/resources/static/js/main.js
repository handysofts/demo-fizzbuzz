/**
 * Created by progr on 2017-09-10.
 */

$(document).ready(function () {


    $('#playFizzBuzz').click(function () {
        playFizzBuzzGame();
    });

    $('#playFizzBuzzForm').keypress(function (e) {
        if (e.which == 13) {
            playFizzBuzzGame();
            return false;
        }
    });

});


/**
 * Show messages
 *
 * @param msg
 */
function alert(msg) {
    $('#messageBox').html('<strong>Error!</strong> ' + msg);
    $('#alertBox').show();
}


/**
 * Fizz Buzz game logic/calls goes here
 */
function playFizzBuzzGame() {
    var resultPanel = $('#resultPanel');
    resultPanel.hide(250);

    var numbers = $('#numbers').val();
    if (numbers.length < 1) {
        alert("Please enter number(s). Example 2,6,15,34");
        return;
    }


    $('#alertBox').hide();
    var form = $('#playFizzBuzzForm');
    $.ajax({
        type: "GET",
        url: form.attr('action').replace("numberList", numbers),
        success: function (response) {
            console.log(response);
            if (response.error == undefined){
                alert("Unknown error occurred! Please contact to developer.")
                return;
            }
            if (response.error.code != 0){
                alert(response.error.message);
                return;
            }

            var resultPanelBody = $('#resultPanelBody');
            resultPanelBody.html('');
            resultPanelBody.append('<strong>Fizz-Buzzed Result: </strong>'+response.fizzBuzzed+"<br/>");
            resultPanel.show(500);
        },
        error: function (request, status, error) {
            alert(request.responseText);
        }
    });
}