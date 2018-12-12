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










