/**
 * Create by : Thanarat
 * Create Date : 09-09-2014
 */

//this parameter use for defind datepicker option of jquery-ui
var pickerOpts = {
					dateFormat : 'dd/mm/yy'
// 					, showOn: 'button'
					, changeMonth: true
					, changeYear: true
					, dayNamesMin: ['อา', 'จ', 'อ', 'พ', 'พฤ', 'ศ', 'ส']
					, monthNamesShort: ['มกราคม','กุมภาพันธ์','มีนาคม','เมษายน','พฤษภาคม','มิถุนายน','กรกฎาคม','สิงหาคม','กันยายน','ตุลาคม','พฤศจิกายน','ธันวาคม']
					, beforeShow:function(){    
			            if($(this).val()!=""){  
			                var arrayDate=$(this).val().split("/");       
			                arrayDate[2]=parseInt(arrayDate[2])-543;  
			                $(this).val(arrayDate[0]+"/"+arrayDate[1]+"/"+arrayDate[2]);  
			            }  
			            setTimeout(function(){  
			                $.each($(".ui-datepicker-year option"),function(j,k){  
			                    var textYear=parseInt($(".ui-datepicker-year option").eq(j).val())+543;  
			                    $(".ui-datepicker-year option").eq(j).text(textYear);  
			                });               
			            },50);  
			        }
					, onChangeMonthYear: function(){  
			            setTimeout(function(){  
			                $.each($(".ui-datepicker-year option"),function(j,k){  
			                    var textYear=parseInt($(".ui-datepicker-year option").eq(j).val())+543;  
			                    $(".ui-datepicker-year option").eq(j).text(textYear);  
			                });               
			            },50);        
			        }
					, onClose:function(){  
			            if($(this).val()!="" && $(this).val()==dateBefore){           
			                var arrayDate=dateBefore.split("/");  
			                arrayDate[2]=parseInt(arrayDate[2])+543;  
			                $(this).val(arrayDate[0]+"/"+arrayDate[1]+"/"+arrayDate[2]);      
			            }         
			        }
					, onSelect: function(dateText, inst){   
			            dateBefore=$(this).val();  
			            var arrayDate=dateText.split("/");  
			            arrayDate[2]=parseInt(arrayDate[2])+543;  
			            $(this).val(arrayDate[0]+"/"+arrayDate[1]+"/"+arrayDate[2]);  
			        }
				};


// Data Table

var processing = true;

$( document ).ready(function(){
	var dataTb = $('table.data-grid').DataTable({
        "processing": processing,
	});
	var btnNewRecord = $('.btn-new-record').button();
});