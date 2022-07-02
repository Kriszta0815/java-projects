$(document).ready(function() {

var refresh = function() {
$("#content").empty();
$.get("http://localhost:9000/users/", function(data) {

for(var i=0; i<data.length; i++) {

    var tr= $("<tr />");
    var td= $("<td />");

    td.append($("<div class='lead' />").text(data[i].firstName));
    td.append($("<div />").text(data[i].lastName));
    td.append($("<div />").text(data[i].opinion));
    tr.append(td);
    $("#content").append(tr);

}
});

};
refresh();
$("#refresh").on("click", refresh);
})