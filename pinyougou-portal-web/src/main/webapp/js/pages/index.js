// window.onload = function() {
// 	cartListController.setup();
// }

/*商品分类*/
$(function() {
	$('.all-sort-list2 > .item').hover(function() {
		//父类分类列表容器的高度

		$(this).addClass('hover');
		$(this).children('.item-list').css('display', 'block');
	}, function() {
		$(this).removeClass('hover');
		$(this).children('.item-list').css('display', 'none');
	});

	$('.item > .item-list > .close').click(function() {
		$(this).parent().parent().removeClass('hover');
		$(this).parent().hide();
	});
});

/*楼层导航*/
function scrollFloorView(){
	var ling = $(document).scrollTop(); //获得窗口滚动上去的距离	
	if(ling > 1200) {
		$("#floor-index").show(); //如果滚动的距离大于1200，滚动框显示出来
	}
	if(1200 < ling && ling < 1600) { //第一层的数字隐藏，文字显示，其他兄弟元素的li数字显示，文字隐藏
		$("#floor-index ul li").eq(0).find(".num").hide().siblings(".word").css("display", "block");
		$("#floor-index ul li").eq(0).siblings("li").find(".num").css("display", "block").siblings(".word").hide();
	} else if(ling < 1800) {
		$("#floor-index ul li").eq(1).find(".num").hide().siblings(".word").css("display", "block");
		$("#floor-index ul li").eq(1).siblings("li").find(".num").css("display", "block").siblings(".word").hide();
	}
	if(ling > 2500 || ling < 1200) {
		$("#floor-index").hide();
	}
}
$(function() {
	scrollFloorView();
	$(window).scroll(function() {
		scrollFloorView();
	});
});

function resizeFloorView(){
	if($(document.body).width() > 1200){
			ele_width = $(document.body).width() - 1200;
			ele_width = ele_width / 2 - 65;
			$("#floor-index").css("left", ele_width + "px");
		}
		else{
			$("#floor-index").css("left", "6px");
		}
}
$(function() {
	resizeFloorView();
	$(window).resize(function() {
		resizeFloorView();
	});
});

/*生活服务区*/
$(function() {

	$(".close").click(function() {
		$("li.tab-item").animate({
			"top": 0
		});
		$(".life-detail").removeClass("lifenow");

	});
	$("li.tab-item").each(function(index) {
		var liNode = $(this);
		$(this).mouseover(function() {
			$("li.tab-item").animate({
				"top": -36
			}, 150);
			$("div.lifenow").removeClass("lifenow");
			$("div.life-detail").eq(index).addClass("lifenow");
			$(this).addClass("tabin");
		});
	})

});

/*产品筛选*/
$(function() {
	$(".type-list li a").hover(
		function() {
			$(this).addClass("redhover");
		},
		function() {
			$(this).removeClass("redhover");
		}
	);

	$(".type-list li a").click(function() {
		$(this).attr("class", "redhover");
		$(".type-list li a").each(function() {
			$(".type-list li a").not(".redhover").attr("class", "grayhover");
		})
		$(this).removeClass(".redhover");
		alert(RetSelecteds());
	})

});

function RetSelecteds() {
	var result = "";
	$(".type-list li a[class='grayhover']").each(function() {
		result += $(this).html() + "\n";
	});
	return result;
}












//影像力换一换
var getyxl = jQuery('#picLBxxl li').eq(0).width();  /*获取li的宽度*/
(function($){
    var arartta= window['arartta'] = function(o){
        return new das(o);
    }
    das = function(o){
        this.obj = $('#'+o.obj);
        this.bnt = $('#'+o.bnt);
        this.showLi = this.obj.find('li');  /*找到每个li*/
        this.current = 0;
        this.myTimersc = '';
        this.init()
    }
    das.prototype = {
        chgPic:function(n){
            var _this = this;
            for (var i = 0,l= _this.showLi.length; i < l; i++) {
                _this.showLi.eq(i).find(".pic").find('img').eq(n).attr('src',_this.showLi.eq(i).find(".pic").find('img').eq(n).attr('nsrc'));

                $('#picLBxxl dl:not(:animated)').animate({left: -(n * getyxl) + "px"}, {easing:"easeInOutExpo"}, 1500, function(){}); 
                /*点击dl,使没有动画的dl执行动画，向左移动负值*/
            }
        },
        rotate:function(){
            var _this = this;
            clearInterval(_this.myTimersc);
            _this.bnt.children().css({
                    '-webkit-transform':'rotate(0deg)',
                    '-moz-transform':'rotate(0deg)'
            });
            var tt = 0;
            var getBnts = _this.bnt.children();
            _this.myTimersc = setInterval(function(){
                tt += 10;
                if (tt >= 180) {
                    clearInterval(_this.myTimersc);
                }
                rotateElement(getBnts,tt);
            },25)
        },
        init:function(){
            var _this = this;
            this.bnt.bind("click",function(){
                _this.current++;
                if (_this.current > 1) { /*如果当前页面数大于1就回到第1页*/
                    _this.current = 0 ;
                }
                _this.chgPic(_this.current);
                _this.rotate();

            })
            this.bnt.mouseenter(function () {
                _this.rotate();
            });

        }
    }
})(jQuery)

arartta({
    bnt:'xxlChg',
    obj:'picLBxxl'
});

function rotateElement(element,angle){
    var rotate = 'rotate('+angle+'deg)';
    if(element.css('MozTransform')!=undefined)
        element.css('MozTransform',rotate);
    else if(element.css('WebkitTransform')!=undefined)
        element.css('WebkitTransform',rotate);
}