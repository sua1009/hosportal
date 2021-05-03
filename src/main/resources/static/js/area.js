$(document).ready(function(){
		// Seoul 서울
		$("#Seoul").on("click",function(){
			var thisVal1 = "서울";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Seoul",
				type : "POST",
				data : datas,
				success : function(Seoul) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Seoul.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Seoul[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Seoul[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Seoul[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Seoul[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Seoul[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Seoul[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Incheon 인천
				$("#Incheon").on("click",function(){
			var thisVal1 = "인천";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Incheon",
				type : "POST",
				data : datas,
				success : function(Incheon) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Incheon.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Incheon[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Incheon[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Incheon[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Incheon[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Incheon[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Incheon[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Gyeonggi 경기
				$("#Gyeonggi").on("click",function(){
			var thisVal1 = "경기";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Gyeonggi",
				type : "POST",
				data : datas,
				success : function(Gyeonggi) {
					$("#remove").remove();
					$("#hosrow").empty();
					for(var i = 0; i < Gyeonggi.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Gyeonggi[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Gyeonggi[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Gyeonggi[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Gyeonggi[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Gyeonggi[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Gyeonggi[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Chungbuk 충북
				$("#Chungbuk").on("click",function(){
			var thisVal1 = "충북";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Chungbuk",
				type : "POST",
				data : datas,
				success : function(Chungbuk) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Chungbuk.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Chungbuk[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Chungbuk[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Chungbuk[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Chungbuk[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Chungbuk[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Chungbuk[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Chungnam 충남
				$("#Chungnam").on("click",function(){
			var thisVal1 = "충남";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Chungnam",
				type : "POST",
				data : datas,
				success : function(Chungnam) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Chungnam.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Chungnam[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Chungnam[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Chungnam[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Chungnam[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Chungnam[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Chungnam[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Gangwon 강원
				$("#Gangwon").on("click",function(){
			var thisVal1 = "강원";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Gangwon",
				type : "POST",
				data : datas,
				success : function(Gangwon) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Gangwon.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Gangwon[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Gangwon[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Gangwon[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Gangwon[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Gangwon[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Gangwon[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Sejong 세종
				$("#Sejong").on("click",function(){
			var thisVal1 = "세종";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Sejong",
				type : "POST",
				data : datas,
				success : function(Sejong) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Sejong.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Sejong[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Sejong[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Sejong[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Sejong[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Sejong[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Sejong[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Daejeon 대전
				$("#Daejeon").on("click",function(){
			var thisVal1 = "대전";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Daejeon",
				type : "POST",
				data : datas,
				success : function(Daejeon) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Daejeon.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Daejeon[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Daejeon[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Daejeon[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Daejeon[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Daejeon[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Daejeon[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Gyeongbuk 경북
				$("#Gyeongbuk").on("click",function(){
			var thisVal1 = "경북";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Gyeongbuk",
				type : "POST",
				data : datas,
				success : function(Gyeongbuk) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Gyeongbuk.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Gyeongbuk[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Gyeongbuk[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Gyeongbuk[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Gyeongbuk[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Gyeongbuk[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Gyeongbuk[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Gyeongnam 경남
				$("#Gyeongnam").on("click",function(){
			var thisVal1 = "경남";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Gyeongnam",
				type : "POST",
				data : datas,
				success : function(Gyeongnam) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Gyeongnam.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Gyeongnam[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Gyeongnam[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Gyeongnam[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Gyeongnam[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Gyeongnam[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Gyeongnam[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Daegu 대구
				$("#Daegu").on("click",function(){
			var thisVal1 = "대구";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Daegu",
				type : "POST",
				data : datas,
				success : function(Daegu) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Daegu.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Daegu[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Daegu[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Daegu[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Daegu[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Daegu[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Daegu[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Jeollabuk 전북
				$("#Jeollabuk").on("click",function(){
			var thisVal1 = "전북";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Jeollabuk",
				type : "POST",
				data : datas,
				success : function(Jeollabuk) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Jeollabuk.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Jeollabuk[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Jeollabuk[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Jeollabuk[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Jeollabuk[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Jeollabuk[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Jeollabuk[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Jeollanam 전남
				$("#Jeollanam").on("click",function(){
			var thisVal1 = "전남";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Jeollanam",
				type : "POST",
				data : datas,
				success : function(Jeollanam) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Jeollanam.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Jeollanam[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Jeollanam[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Jeollanam[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Jeollanam[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Jeollanam[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Jeollanam[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Gwangju 광주
				$("#Gwangju").on("click",function(){
			var thisVal1 = "광주";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Gwangju",
				type : "POST",
				data : datas,
				success : function(Gwangju) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Gwangju.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Gwangju[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Gwangju[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Gwangju[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Gwangju[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Gwangju[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Gwangju[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Ulsan 울산
				$("#Ulsan").on("click",function(){
			var thisVal1 = "울산";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Ulsan",
				type : "POST",
				data : datas,
				success : function(Ulsan) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Ulsan.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Ulsan[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Ulsan[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Ulsan[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Ulsan[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Ulsan[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Ulsan[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Busan 부산
				$("#Busan").on("click",function(){
			var thisVal1 = "부산";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Busan",
				type : "POST",
				data : datas,
				success : function(Busan) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Busan.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Busan[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Busan[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Busan[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Busan[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Busan[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Busan[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		// Jeju 제주
				$("#Jeju").on("click",function(){
			var thisVal1 = "제주";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Jeju",
				type : "POST",
				data : datas,
				success : function(Jeju) {
					$("#hosrow").empty();
					$("#remove").remove();
					for(var i = 0; i < Jeju.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/normal/hospital/detail/"+Jeju[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Jeju[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Jeju[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Jeju[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Jeju[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Jeju[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
// 스크립트 종료		
	});