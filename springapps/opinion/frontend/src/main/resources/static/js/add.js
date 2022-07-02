$(document).ready(function() {

    $(".successarea").hide();
$("#send").on("click", function() {

var data = {
firstName:$("#firstName").val(),
lastName:$("#lastName").val(),
opinion:$("#opinion").val()
};

$.ajax({
url:"http://localhost:9000/users/",
method:"POST",
contentType:"application/json",
data:JSON.stringify(data),
success:function(data) {
 $(".successarea").show();
 $("form").hide();
},
error:function(data) {
alert("Something went wrong");
}

});


});


})