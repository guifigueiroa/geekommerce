// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });
    })(jQuery);
}


$("#add-box-item").click(function(){
  var name = $("#name").val();
  $.ajax({
    type: "POST",
    url: "/productType/save",
    contentType: "application/json",
    dataType: 'json',
    data: JSON.stringify({ name: name }),
    success: function( msg ) {
      $( "#error" ).html("");
      $( "#items" ).append( "<li class=\"list-group-item\">"+name+"</li>" );
    },
    error: function (jqXHR, exception) {
      var obj = JSON.parse(jqXHR.responseText);
      $( "#error" ).html(obj.errors[0].message);
    }
  });
});
