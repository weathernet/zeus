/*动态设置html的font-size大小*/
(function (doc, win) {
  var docEl = doc.documentElement,
    resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
    recalc = function () {
      var clientWidth = docEl.clientWidth;
      if (!clientWidth) return;
      if(clientWidth>=750){
        docEl.style.fontSize = '100px';
      }else{
        docEl.style.fontSize = 100 * (clientWidth / 640) + 'px';
      }
    };
  if (!doc.addEventListener) return;
  win.addEventListener(resizeEvt, recalc, false);
  doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);

// 获取验证码倒计时
function getRegisterCode(){
	var seconds = 60;
    $(".registerCode_btn").attr("disabled",true);
    var timer = setInterval(function(){
        seconds --;
        $(".registerCode_btn").text("重新发送"+seconds);
        if(seconds == 0) {
            $(".registerCode_btn").attr("disabled",false);
            $(".registerCode_btn").text("获取验证码");
            clearInterval(timer);
        }
    },1000)
}
// 后退
$("header > i").on("click",function(){
	window.history.back();
})
$(".m1").on("click",function(){
	window.history.back();
})
$(".d1").on("click",function(){
	window.history.back();
})
// 发布整租 合租切换
$(".fabu .info-title span").on("click",function() {
	$(this).addClass("active").siblings().removeClass("active");
})
// 商家售卖商品 状态切换
$(".my-goodsTitle span").on("click",function () {
	$(this).addClass("active").siblings().removeClass("active");
})
// 商家售卖商品 列表切换
$(".my-goodsTitle span").on("click",function () {
	var index = $(this).index();
	$(".goods-list ul").hide();
	$(".goods-list ul").eq(index).show();
})

// 充值中心页面
$(".recharge").on("click",function() {
	window.location.href = "recharge.html"
})
// 我的管家页面
$(".my-steward").on("click",function() {
	window.location.href = "my_steward.html"
})
// 商城页面
$(".qg_shangcheng").on("click",function() {
	window.location.href = "jiazhengweixiu.html#1"
})
// 旅游
$(".qg_shanglv").on("click",function() {
	window.location.href = "jiazhengweixiu.html#2"
})


