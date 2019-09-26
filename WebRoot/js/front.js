Pn.ns('JCore','JCore.CheckCode');
JCore.showFlash = function(str, wid, hei) {
	var fs = "<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0' width='"
			+ wid + "' height='" + hei + "'>";
	fs += "<param name='movie' value='" + str + "'>";
	fs += "<param name='wmode' value='transparent'>";
	fs += "<embed src='" + str;
	fs += "' quality='high' pluginspage='http://www.macromedia.com/go/getflashplayer' type='application/x-shockwave-flash' width='"
			+ wid + "' height='" + hei + "'></embed></object>";
	document.write(fs);
}
/**
 * @param input
 *            验证码输入框jquery对象。
 * @param url
 *            验证码的url地址。
 * @param top
 *            上下偏移量。
 */
JCore.CheckCode.cssClass = 'j-chkcode';
JCore.CheckCode.url = '/CheckCode.svl';
JCore.CheckCode = function(input, url, top) {
	this.input = input;
	this.url = url || JCore.CheckCode.url;
	this.top = top || 45;
	this.imgLayer = null;
	this.img = null;
	this.event = null;
	this.isShow = false;
	var o = this;
	var showImg = function() {
		if (o.imgLayer == null) {
			o.createHtml();
		}
		if (!o.isShow) {
			var d = new Date().getTime();
			o.img.attr('src', o.url + '?d=' + d);
			var offset = o.input.offset();
			o.imgLayer.show();
			o.imgLayer.css('top', offset.top - o.top + 'px');
			o.imgLayer.css('left', offset.left + 'px');
			o.isShow = true;
		}
	};
	var hideImg = function() {
		if (o.isShow) {
			o.event = setTimeout(function() {
				o.imgLayer.hide();
				o.isShow = false;
			}, 200);
		}
	};
	this.input.bind('focus', showImg);
	this.input.bind('blur', hideImg);
};
JCore.CheckCode.prototype.createHtml = function() {
	this.imgLayer = $('<div/>');
	this.img = $('<img border="0" alt="验证码看不清楚?请点击刷新验证码"/>');
	var o = this;
	this.img.bind('click', function() {
		o.input.focus();
		if (o.event) {
			clearTimeout(o.event);
		}
		this.src = o.url + '?d=' + new Date().getTime();
	});
	this.img.appendTo(this.imgLayer);
	this.imgLayer.appendTo(document.body);
	this.imgLayer.addClass('j-chkcode');
};
/**
 * 向上滚动js类
 */
JCore.UpRoller = function(rid, speed, isSleep, sleepTime, rollCount, rollSpan,
		unitHight) {
	this.speed = speed;
	this.rid = rid;
	this.isSleep = isSleep;
	this.sleepTime = sleepTime;
	this.rollCount = rollCount;
	this.rollSpan = rollSpan;
	this.unitHight = unitHight;
	this.proll = $('#roll-' + rid);
	this.prollOrig = $('#roll-orig-' + rid);
	this.prollCopy = $('#roll-copy-' + rid);
	// this.prollLine = $('#p-roll-line-'+rid);
	this.sleepCount = 0;
	this.prollCopy[0].innerHTML = this.prollOrig[0].innerHTML;
	var o = this;
	this.pevent = setInterval(function() {
		o.roll.call(o)
	}, this.speed);
}
JCore.UpRoller.prototype.roll = function() {
	if (this.proll[0].scrollTop > this.prollCopy[0].offsetHeight) {
		this.proll[0].scrollTop = this.rollSpan + 1;
	} else {
		if (this.proll[0].scrollTop % (this.unitHight * this.rollCount) == 0
				&& this.sleepCount <= this.sleepTime && this.isSleep) {
			this.sleepCount++;
			if (this.sleepCount >= this.sleepTime) {
				this.sleepCount = 0;
				this.proll[0].scrollTop += this.rollSpan;
			}
		} else {
			var modCount = (this.proll[0].scrollTop + this.rollSpan)
					% (this.unitHight * this.rollCount);
			if (modCount < this.rollSpan) {
				this.proll[0].scrollTop += this.rollSpan - modCount;
			} else {
				this.proll[0].scrollTop += this.rollSpan;
			}
		}
	}
}
JCore.LeftRoller = function(rid, speed, rollSpan) {
	this.rid = rid;
	this.speed = speed;
	this.rollSpan = rollSpan;
	this.proll = $('#roll-' + rid);
	this.prollOrig = $('#roll-orig-' + rid);
	this.prollCopy = $('#roll-copy-' + rid);
	this.prollCopy[0].innerHTML = this.prollOrig[0].innerHTML;
	var o = this;
	this.pevent = setInterval(function() {
		o.roll.call(o)
	}, this.speed);
}
JCore.LeftRoller.prototype.roll = function() {
	if (this.proll[0].scrollLeft > this.prollCopy[0].offsetWidth) {
		this.proll[0].scrollLeft = this.rollSpan + 1;
	} else {
		this.proll[0].scrollLeft += this.rollSpan;
	}
}
JCore.checkUserName = function(username,base) {
	base = base || '';
	$.postJson(base + '/jeecms/core/ajax/checkUserName.do', {
		'username' : username
	}, function(data) {
		if (data.success) {
			alert('该用户名没有被注册，可以使用。');
		} else {
			alert('该用户名已经被注册！');
		}
	});
}