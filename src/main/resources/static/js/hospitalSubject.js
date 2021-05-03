// ------------------------------------------------------------ 피부과 정렬 부분 -------------------------------------------------------------------
	$(document).ready(function(){
		//피부과 정렬
		$("#Dermatology").on("click",function(){
			var thisVal1 = "피부과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Dermatology",
				type : "POST",
				data : datas,
				success : function(Dermatology) {
					$("#hosrow").empty();
					for(var i = 0; i < Dermatology.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Dermatology[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Dermatology[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Dermatology[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Dermatology[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Dermatology[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Dermatology[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
		
		
// ------------------------------------------------------------ 치과 정렬 부분 -------------------------------------------------------------------------
		$("#Dentist").on("click",function(){
			var thisVal1 = "치과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Dentist",
				type : "POST",
				data : datas,
				success : function(Dentist) {
					$("#hosrow").empty();
					for(var i = 0; i < Dentist.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Dentist[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Dentist[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Dentist[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Dentist[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Dentist[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 안과 정렬 부분 -------------------------------------------------------------------------
		$("#Ophthalmology").on("click",function(){
			var thisVal1 = "안과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Ophthalmology",
				type : "POST",
				data : datas,
				success : function(Ophthalmology) {
					$("#hosrow").empty();
					for(var i = 0; i < Ophthalmology.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Ophthalmology[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Ophthalmology[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Ophthalmology[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Ophthalmology[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Ophthalmology[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Ophthalmology[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 내과 정렬 부분 -------------------------------------------------------------------------

		$("#medicine").on("click",function(){
			var thisVal1 = "내과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/medicine",
				type : "POST",
				data : datas,
				success : function(medicine) {
					$("#hosrow").empty();
					for(var i = 0; i < medicine.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+medicine[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(medicine[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(medicine[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+medicine[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+medicine[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+medicine[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 한의원 정렬 부분 ------------------------------------------------------------------------
			
		$("#Orientalmedicine").on("click",function(){
			var thisVal1 = "한의원";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Orientalmedicine",
				type : "POST",
				data : datas,
				success : function(Orientalmedicine) {
					$("#hosrow").empty();
					for(var i = 0; i < Orientalmedicine.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Orientalmedicine[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Orientalmedicine[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Orientalmedicine[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Orientalmedicine[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Orientalmedicine[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Orientalmedicine[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 산부인과 정렬 부분 ----------------------------------------------------------------------

		$("#Obstetricsandgynecology").on("click",function(){
			var thisVal1 = "산부인과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Obstetricsandgynecology",
				type : "POST",
				data : datas,
				success : function(Obstetricsandgynecology) {
					$("#hosrow").empty();
					for(var i = 0; i < Obstetricsandgynecology.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Obstetricsandgynecology[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Obstetricsandgynecology[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Obstetricsandgynecology[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Obstetricsandgynecology[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Obstetricsandgynecology[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Obstetricsandgynecology[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 성형외과 정렬 부분 ----------------------------------------------------------------------

		$("#PlasticSurgery").on("click",function(){
			var thisVal1 = "성형외과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/PlasticSurgery",
				type : "POST",
				data : datas,
				success : function(PlasticSurgery) {
					$("#hosrow").empty();
					for(var i = 0; i < PlasticSurgery.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+PlasticSurgery[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(PlasticSurgery[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(PlasticSurgery[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+PlasticSurgery[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+PlasticSurgery[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+PlasticSurgery[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 소아청소년과 정렬 부분 -------------------------------------------------------------------

		$("#DepartmentofPediatricsandAdolescents").on("click",function(){
			var thisVal1 = "소아청소년과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/DepartmentofPediatricsandAdolescents",
				type : "POST",
				data : datas,
				success : function(DepartmentofPediatricsandAdolescents) {
					$("#hosrow").empty();
					for(var i = 0; i < DepartmentofPediatricsandAdolescents.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+DepartmentofPediatricsandAdolescents[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(DepartmentofPediatricsandAdolescents[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(DepartmentofPediatricsandAdolescents[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+DepartmentofPediatricsandAdolescents[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+DepartmentofPediatricsandAdolescents[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+DepartmentofPediatricsandAdolescents[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});


// ------------------------------------------------------------ 이비인후과 정렬 부분 -----------------------------------------------------------------

		$("#Otorhinolaryngology").on("click",function(){
			var thisVal1 = "이비인후과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Otorhinolaryngology",
				type : "POST",
				data : datas,
				success : function(Otorhinolaryngology) {
					$("#hosrow").empty();
					for(var i = 0; i < Otorhinolaryngology.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Otorhinolaryngology[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Otorhinolaryngology[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Otorhinolaryngology[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Otorhinolaryngology[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Otorhinolaryngology[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Otorhinolaryngology[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 가정의학과 정렬 부분 -----------------------------------------------------------------

		$("#DepartmentofFamilyMedicine").on("click",function(){
			var thisVal1 = "가정의학과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/DepartmentofFamilyMedicine",
				type : "POST",
				data : datas,
				success : function(DepartmentofFamilyMedicine) {
					$("#hosrow").empty();
					for(var i = 0; i < DepartmentofFamilyMedicine.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+DepartmentofFamilyMedicine[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(DepartmentofFamilyMedicine[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(DepartmentofFamilyMedicine[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+DepartmentofFamilyMedicine[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+DepartmentofFamilyMedicine[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+DepartmentofFamilyMedicine[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 정신건강의학과 정렬 부분 --------------------------------------------------------------

		$("#DepartmentofMentalHealthMedicine").on("click",function(){
			var thisVal1 = "정신건강의학과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/DepartmentofMentalHealthMedicine",
				type : "POST",
				data : datas,
				success : function(DepartmentofMentalHealthMedicine) {
					$("#hosrow").empty();
					for(var i = 0; i < DepartmentofMentalHealthMedicine.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+DepartmentofMentalHealthMedicine[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(DepartmentofMentalHealthMedicine[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(DepartmentofMentalHealthMedicine[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+DepartmentofMentalHealthMedicine[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+DepartmentofMentalHealthMedicine[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+DepartmentofMentalHealthMedicine[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 재활의학과 정렬 부분 -----------------------------------------------------------------

		$("#DepartmentofRehabilitationMedicine").on("click",function(){
			var thisVal1 = "재활의학과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/DepartmentofRehabilitationMedicine",
				type : "POST",
				data : datas,
				success : function(DepartmentofRehabilitationMedicine) {
					$("#hosrow").empty();
					for(var i = 0; i < DepartmentofRehabilitationMedicine.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+DepartmentofRehabilitationMedicine[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(DepartmentofRehabilitationMedicine[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(DepartmentofRehabilitationMedicine[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+DepartmentofRehabilitationMedicine[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+DepartmentofRehabilitationMedicine[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+DepartmentofRehabilitationMedicine[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 외과 정렬 부분 ---------------------------------------------------------------------
			
		$("#surgery").on("click",function(){
			var thisVal1 = "외과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/surgery",
				type : "POST",
				data : datas,
				success : function(surgery) {
					$("#hosrow").empty();
					for(var i = 0; i < surgery.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+surgery[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(surgery[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(surgery[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+surgery[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+surgery[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+surgery[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 정형외과 정렬 부분 ------------------------------------------------------------------

		$("#Orthopedics").on("click",function(){
			var thisVal1 = "정형외과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Orthopedics",
				type : "POST",
				data : datas,
				success : function(Orthopedics) {
					$("#hosrow").empty();
					for(var i = 0; i < Orthopedics.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Orthopedics[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Orthopedics[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Orthopedics[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Orthopedics[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Orthopedics[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Orthopedics[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 신경과 정렬 부분 -------------------------------------------------------------------

		$("#Neurology").on("click",function(){
			var thisVal1 = "신경과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/Neurology",
				type : "POST",
				data : datas,
				success : function(Neurology) {
					$("#hosrow").empty();
					for(var i = 0; i < Neurology.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+Neurology[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(Neurology[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(Neurology[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+Neurology[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+Neurology[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+Neurology[i].hospitalName+"</p>"
								);
					}
				},
				error: function() {
					alert("test error");
				}
			});
		});
// ------------------------------------------------------------ 비뇨기과 정렬 부분 ------------------------------------------------------------------

		$("#urology").on("click",function(){
			var thisVal1 = "비뇨기과";
			var datas = {search_param : thisVal1}
			$.ajax({
				url : "/hosportal/urology",
				type : "POST",
				data : datas,
				success : function(urology) {
					$("#hosrow").empty();
					for(var i = 0; i < urology.length; i++) {
						$("#hosrow").append(
								"<div class='col-sm-3 p-1 mb-2' style='height: 500px;' id='hospitalNo"+i+"'></div>"
								);
						$("#hospitalNo"+i+"").append(
				                "<a href='/hospital/hospital/detail/"+urology[i].hospitalId+"' style='text-decoration: none;' id='hospitalCard"+i+"'></a>"
								);
						$("#hospitalCard"+i+"").append(
			                    "<div class='hospitalImg' id='hospitalImg"+i+"'></div>",
								"<div class='hospitalAddr mt-3 p-2' id='hospitalAddr"+i+"'></div>",
			                    "<div class='hospitalName' id='hospitalName"+i+"'></div>"
								);
						if(urology[i].fileName == null){
							$("#hospitalImg"+i+"").append(
								"<img src='../img/img1.png' width='100%' height='100%' >" 
							);				
						}
						if(urology[i].fileName != null){
							$("#hospitalImg"+i+"").append(
								"<img src='"+urology[i].fileName+"' width='100%' height='100%'>" 
							);				
						}
						$("#hospitalAddr"+i+"").append(
								"<h5 class='small my-2 text-muted text-center'>"+urology[i].hospitalAddress2+"</h5>"
								);
						$("#hospitalName"+i+"").append(
								"<p class='text-center'>"+urology[i].hospitalName+"</p>"
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