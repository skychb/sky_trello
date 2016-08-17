var TODO = (function (window){

	 'use strict';

	 var board_btn = " <li class='board waves-effect waves-light btn'>" +
	 						"{{input-value}}" +
	 					"</li>"

	function init(){

		$("#boards_list").on("click", ".board", page_nav);
		$("#create_board").on("click", create_board);
		$(".add_project_btn").on("click", create_new_project);
		$(".save").on("click", add_project);
		$(".add_project a.cancel").on("click", cancel);
	}

	function cancel(){

		$(".btn-floating").css('display','block');
		$(".add_project_form").css('display','none');

	}

	function add_project(){
		var project_name = $("#add_project").val();
		var data = JSON.stringify({"boardName":project_name});
		$.ajax({
		      type: "POST",
//		      contentType을 입력하지 않으면 415 에러가 뜸. (Unsupported Media Type) MIME을 중시..
		      contentType: "application/json",
		      url: '/api/board/addBoard',
		      data: data,
		      success: function(result){
    		  	var html = "<a href='/project/" + result.id + "'>" + result.boardName + "</>";
		  	    var name = board_btn.replace(/\{\{input-value\}\}/gi,html);
				$(".add_project").before(name);
				$("#add_project").val("");
				$(".add_project_form").css('display','none');
				$(".btn-floating").css('display','block');
		    	  }
		});
		
//		 $.post("/project", {"boardName" : project_name})
//		 .done(function(data) {
//		   		var html = "<a href='/project/" + result.id + "'>" + result.boardName + "</>";
//		   		var name = board_btn.replace(/\{\{input-value\}\}/gi,html);
//		 		$(".add_project").before(name);
//		 		$("#add_project").val("");
//		 		$(".add_project_form").css('display','none');
//		 		$(".btn-floating").css('display','block');
//		 }, "json"); 얘는 applicationType을 지원하지 않아서 사용할 수 없음.
		// var project_name = $("#add_project").val();
		// var str = board_btn.replace(/\{\{input-value\}\}/gi,project_name);
	}

	function create_new_project(){

		$(".add_project_btn").css('display','none');
		$(".add_project_form").css('display','block');
	}

	function page_nav(){

		window.location.href = ("page.html");
	}

	function create_board(){


		$("#boards_list").prepend(board_btn);
	}


	return {
		"init" : init
	}
})(window);

$(function(){
    TODO.init();
});
