/*
Duosi Principles of Computer Composition Virtual Experiment System ,DS-VLAB v1.0
Copyright(C)2013 ZHANG Wen-fen, Email: yydzhwf@163.com  Address: Xiangnan University, Chenzhou Hunan, China
This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.

��˼��������ԭ����������ʵ��ϵͳ, DS-VLAB v1.0 
��Ȩ����(C) �����, ��������: yydzhwf@163.com
������Ϊ������������������������������������GNU GENERAL PUBLIC LICENSE���Ա������ٴη�����/���޸ġ�

���ߣ�����ѧԺ�����ͨ�Ź���ѧԺ�������ʦ
*/



function Circuit() {
    this.componentAll = [];  //�ѻ�����ʵ�������б�(��������ɾ���ģ�
    this.count = 0;   //����������������ɾ����������������������id
    this.linecolor = "yellow";
    var targetPin = null;  //��������ʱ��Ŀ������
    var _this = this;
    

    //�ڸ���div��parentId����ָ��λ�ã�offsetX, offsetY��������ʵ��������componentName��
    this.addComponent = function (parentId, componentName, offsetX, offsetY, componentId) {
        var component = new window[componentName]();
        if (componentId == null) {
            component.id = "CP" + String(this.count);
        } else {
            component.id = componentId;
        };
        this.count = this.count + 1;
        _this.componentAll.push(component);
        var compDiv = document.createElement("div");
        compDiv.id = component.id;
        compDiv.style.position = "absolute";
        compDiv.style.left = offsetX + "px";           
        compDiv.style.top = offsetY+ "px";
        compDiv.style.width = component.width + "px";
        compDiv.style.height = component.height + "px";
        compDiv.style.zIndex = 3000 + this.count;
        $("#" + parentId).append(compDiv);

        if (component.image != "") {
            compDiv.style.backgroundImage = "url(" + component.image + ")";
        };
        if (component.showBorder == true && component.showName == false) {
            compDiv.className = "window2";
        };
        if (component.showBorder == true && component.showName == true) {
            var underDiv = document.createElement("div");
            underDiv.id = component.id + "UnderLayer";
            underDiv.className = "window";
            underDiv.style.left = "0px";
            underDiv.style.top = "0px";
            underDiv.style.width = component.width + "px";
            underDiv.style.height = component.height + "px";
            underDiv.style.lineHeight = component.height + "px";
            underDiv.innerHTML = "<strong>" + component.name + "</strong>";
            $("#" + compDiv.id).append(underDiv);
        };

        //������������
        var pinDiv, pn, pinFun;
        for (var i = 0; i < component.pinName.length; i++) {
            pinDiv = document.createElement("div");
            pinDiv.id = compDiv.id + "Pin" + i;
            pinDiv.className = "pin";
            pn=component.pinName[i];
            if (pn=="") {
                pinDiv.style.width = component.pinWidth + "px";
            } else {
                pinDiv.style.width = component.pinWidth + 2 + "px"; //�����ż䲿���ص����ֺÿ�Щ
            };
            pinDiv.style.height = component.pinHeight + "px";
            pinDiv.style.left = component.paddingLR + (component.width - component.paddingLR * 2) * component.pinPosition[i][0] + "px";
            if (component.pinPosition[i][1] == 1) {
                if (component.showBorder == true) {
                    pinDiv.style.top = component.height - component.pinHeight + "px";
                } else {
                    pinDiv.style.top = component.height - component.pinHeight-1 + "px";
                };
                if (pn != "" && component.showPinNo != false) pinDiv.innerHTML = pn + "<br>" + i;
                if (pn != "" && component.showPinNo == false) pinDiv.innerHTML = pn ;
            };
            if (component.pinPosition[i][1] == 0) {
                pinDiv.style.top = 0 + "px";
                if (pn != "" && component.showPinNo != false) pinDiv.innerHTML = i + "<br>" + pn;
                if (pn != "" && component.showPinNo == false) pinDiv.innerHTML = pn;
            };
            pinFun = component.pinFunction[i];
            if (pinFun == 10 || pinFun == 0) {   //�������������
                pinDiv.style.color = "#003C9D";
                $(pinDiv).bind("mousedown", doNone);
                $(pinDiv).bind("mouseenter", function () { targetPin = this;});
                $(pinDiv).bind("mouseleave", function () { targetPin = null;});
            };
            if (pinFun == 1) {   //������������
                pinDiv.style.color = "green";
                $(pinDiv).bind("mousedown", lineDrag);
            };
            if (pinFun == 11) {   //���������/�������
                pinDiv.style.color = "#b200ff";
                $(pinDiv).bind("mouseenter", function () { targetPin = this; });
                $(pinDiv).bind("mouseleave", function () { targetPin = null; });
                $(pinDiv).bind("mousedown", lineDrag);
            };
            if (pinFun >= 2) {   //�������������
                $(pinDiv).bind("mousedown", doNone);
            };

            pinDiv.onselectstart = function () { return false; };//����div�е����ֱ�ѡ��

            $("#" + compDiv.id).append(pinDiv);
        };

        dragEnabled(compDiv.id);
        $(compDiv).bind("mousedown", deleteC);
        if(component.name=="Switch")
            $(compDiv).bind("mousedown", switchClick);
        if (component.name == "SinglePulse")
            $(compDiv).bind("mousedown", singlePulseClick);

        if (pn != "" && component.showPinNo != false)
            $(compDiv).bind("dblclick", showPinValue);
    };     





    //����һ��������
    this.lineCreate=function (paintDiv, fromX, fromY, toX, toY) {
        var newLine = document.createElement("v:shape");
        var path = "m " + fromX + "," + fromY + " l " + toX + "," + toY + " e";
        newLine.setAttribute("class","line");
        newLine.setAttribute("filled", "f");
        newLine.setAttribute("coordsize", "100,100");
        newLine.setAttribute("strokecolor",_this.linecolor);
        newLine.setAttribute("path", path);
        newLine.innerHTML = "<v:Stroke endarrow=\"classic\"/>";
        $("#" + paintDiv).append(newLine);
        $(newLine).bind("mousedown", deleteL);
        newLine.onmouseover = lineOver;
        newLine.onmouseout = lineOut;
        return newLine;
    };

    //����������ʱ������ʼ����Ŀ����϶��Ĺ����У��ߵı仯
    function lineChange(line, fromX, fromY, toX, toY) {
        var p1X, p1Y, p2X, p2Y;
        if (Math.abs(fromX - toX) > Math.abs(fromY - toY)) {
            p1X = fromX + Math.round((toX - fromX) / 2);
            p1Y = fromY;
            p2X = fromX + Math.round((toX - fromX) / 2);
            p2Y = toY;
            if (fromX > toX) { toX = toX + 7 }
            else { toX = toX - 7 };
        } else {
            p1X = fromX;
            p1Y = fromY + Math.round((toY - fromY) / 2);
            p2X = toX;
            p2Y = fromY + Math.round((toY - fromY) / 2);
            if (fromY > toY) { toY = toY + 7 }
            else { toY = toY - 7 };
        };
        line.path = "m " + fromX + "," + fromY + " l " + p1X + "," + p1Y + "," + p2X + "," + p2Y + "," + toX + "," + toY + " e";
    };

    //����������ʱ����굽��Ŀ�����ź󣬵�������λ�����ߣ��϶�����ʱ������������
    this.lineAdjust = function (line, startPin, endPin) {
        var sX, sY, eX, eY;
        var st = startPin.offsetTop;
        var et = endPin.offsetTop;
        sX = startPin.parentNode.offsetLeft + startPin.offsetLeft + Math.round(startPin.offsetWidth / 2)-1;
        if (st < 2) sY = startPin.parentNode.offsetTop;
        else sY = startPin.parentNode.offsetTop + startPin.parentNode.offsetHeight;
        eX = endPin.parentNode.offsetLeft + endPin.offsetLeft + Math.round(endPin.offsetWidth / 2)-1;
        if (et < 2) eY = endPin.parentNode.offsetTop;
        else eY = endPin.parentNode.offsetTop + endPin.parentNode.offsetHeight;

        if (eY - sY > 10 && st > 1 && et < 2) {
            var p1X = sX;
            var p1Y = sY + Math.round((eY - sY) / 2);
            var p2X = eX;
            var p2Y = sY + Math.round((eY - sY) / 2);
            line.path = "m " + sX + "," + sY + " l " + p1X + "," + p1Y + "," + p2X + "," + p2Y + "," + eX + "," + eY + " e";
        };
        if (eY - sY < 10 && st > 1 && et < 2) {
            var p1X = sX;
            var p1Y = sY + 30;
            var p2X = sX + Math.round((eX - sX) / 2);
            var p2Y = sY + 30;
            var p3X = p2X;
            var p3Y = eY - 30;
            var p4X = eX;
            var p4Y = eY - 30;
            line.path = "m " + sX + "," + sY + " l " + p1X + "," + p1Y + "," + p2X + "," + p2Y + "," + p3X + "," + p3Y + "," + p4X + "," + p4Y + "," + eX + "," + eY + " e";
        };
        if (st > 1 && et >1) {
            var p1X = sX;
            if (eY > sY) {
                var p1Y = eY + 30;
                var p2Y = eY + 30;
            } else {
                var p1Y = sY + 30;
                var p2Y = sY + 30;
            };
            var p2X = eX;
            line.path = "m " + sX + "," + sY + " l " + p1X + "," + p1Y + "," + p2X + "," + p2Y + "," + eX + "," + eY + " e";
        };
        if (st <2 && et <2) {
            var p1X = sX;
            if (eY > sY) {
                var p1Y = sY - 30;
                var p2Y = sY - 30;
            } else {
                var p1Y = eY - 30;
                var p2Y = eY - 30;
            };
            var p2X = eX;
            line.path = "m " + sX + "," + sY + " l " + p1X + "," + p1Y + "," + p2X + "," + p2Y + "," + eX + "," + eY + " e";
        };
        if (sY - eY > 10 && st <2 && et>1) {
            var p1X = sX;
            var p1Y = sY - Math.round((sY -eY ) / 2);
            var p2X = eX;
            var p2Y = sY - Math.round((sY - eY) / 2);
            line.path = "m " + sX + "," + sY + " l " + p1X + "," + p1Y + "," + p2X + "," + p2Y + "," + eX + "," + eY + " e";
        };
        if (sY - eY < 10 && st<2 && et >1) {
            var p1X = sX;
            var p1Y = sY - 30;
            var p2X = sX + Math.round((eX - sX) / 2);
            var p2Y = sY - 30;
            var p3X = p2X;
            var p3Y = eY + 30;
            var p4X = eX;
            var p4Y = eY + 30;
            line.path = "m " + sX + "," + sY + " l " + p1X + "," + p1Y + "," + p2X + "," + p2Y + "," + p3X + "," + p3Y + "," + p4X + "," + p4Y + "," + eX + "," + eY + " e";
        };
    };



    //������ŵ�����¼�
    function lineDrag(a) {
        window.event.cancelBubble = true;  //��ֹ�¼�ð�ݵ���һ��
        if (!a) a = window.event;
        var d = document;
        var sTop = Math.max(d.body.scrollTop, d.documentElement.scrollTop);
        var sLeft = Math.max(d.body.scrollLeft, d.documentElement.scrollLeft);
        var ox = a.clientX + sLeft, oy = a.clientY + sTop;
        var line = _this.lineCreate("demo", ox, oy, ox, oy);
        targetPin = null;
        var originPin = this;

        d.onmousemove = function (a) {
            if (!a) a = window.event;
            var sTop = Math.max(d.body.scrollTop, d.documentElement.scrollTop);
            var sLeft = Math.max(d.body.scrollLeft, d.documentElement.scrollLeft);
            if (targetPin == null) {  //��껹û����Ŀ���ʱ
                lineChange(line, ox, oy, a.clientX + sLeft, a.clientY + sTop);
            } else { //����ѽ���Ŀ������ʱ
                _this.lineAdjust(line, originPin, targetPin);
            }
        }

        d.onmouseup = function () {
            if (targetPin == null) {//���û�н����κ�Ŀ������                   ���޸ģ���Ӧ�ü��Ŀ�������Ƿ��Ѿ���������
                line.removeNode(true);
            } else {
                _this.lineAdjust(line, originPin, targetPin);
                _this.addLineToComponent(line, originPin, targetPin);
            };
            d.onmousemove = null;
            d.onmouseup = null;

        }
    };


    //�������ź��������ŵ�mousedown�¼�
    function doNone(a) {
        window.event.cancelBubble = true;  //��ֹ�¼�ð�ݵ���һ��
    };

    //����id��componentAll���ҵ�ƥ�������
    this.findById=function(Id) {
        for (var i = 0 ; i < _this.componentAll.length; i++) {
            if (_this.componentAll[i].id == Id)
                return _this.componentAll[i];
        };
        return 0;
    };

    //����id��componentAll���ҵ�ƥ���������ɾ��
    function deleteById(Id) {
        for (var i = 0 ; i < _this.componentAll.length; i++) {   
            if (_this.componentAll[i].id == Id) {
                _this.componentAll[i]=null;
                _this.componentAll.splice(i, 1);
                return 1;
            };    
        };
        return 0;
    };


    //����������Ϣ���浽����������,����line.id
    this.addLineToComponent = function (line, startPin, endPin) {
        var sPId, ePId, sCId, sPNo, eCId, ePNo, p;
        sPId = startPin.id;     
        p= sPId.indexOf("Pin");
        sCId = sPId.substring(0, p);//��ȡ��ʼ���ŵ�����ID
        sPNo = sPId.substring(p + 3);//��ȡ��ʼ���ŵı��
        ePId = endPin.id;
        p = ePId.indexOf("Pin");
        eCId = ePId.substring(0, p);
        ePNo = ePId.substring(p + 3);
        var sc = _this.findById(sCId);
        sc.connection[sPNo].push([line, startPin, endPin]);
        var ec = _this.findById(eCId);
        ec.connection[ePNo].push([line, startPin, endPin]);
        line.id = sPId + "To" + ePId;
    };

    //�϶�����cʱ������������������
    this.lineReplace=function(c) {
        var comp = _this.findById(c.id);
        var i, j, l, s, e;
        for (i = 0; i < comp.connection.length; i++) {
            for (j = 0; j < comp.connection[i].length; j++) {
                l = comp.connection[i][j][0];
                s = comp.connection[i][j][1];
                e = comp.connection[i][j][2];
                _this.lineAdjust(l, s, e);
            };
        };     
    };


    //ɾ��������
    function lineDelete(line) {
        var lId, sPId, ePId, sCId, sPNo, eCId, ePNo, p,i;
        lId = line.id;
        p = lId.indexOf("To");
        sPId = lId.substring(0, p);
        ePId = lId.substring(p+2);
        p = sPId.indexOf("Pin");
        sCId = sPId.substring(0, p);//��ȡ��ʼ���ŵ�����ID
        sPNo = sPId.substring(p + 3);//��ȡ��ʼ���ŵı��
        p = ePId.indexOf("Pin");
        eCId = ePId.substring(0, p);
        ePNo = ePId.substring(p + 3);
        var sc = _this.findById(sCId);
        for (i = 0; i < sc.connection[sPNo].length; i++) {
            if (sc.connection[sPNo][i][0] == line) {
                sc.connection[sPNo].splice(i, 1);
                break;
            };
        };
        var ec = _this.findById(eCId);
        for (i = 0; i < ec.connection[ePNo].length; i++) {
            if (ec.connection[ePNo][i][0] == line) {
                ec.connection[ePNo].splice(i, 1);
                break;
            };
        };
        line.removeNode(true);
    };

    //�һ�ɾ�������ߵ�����¼�
    function deleteL(a) {
        if (!a) a = window.event;
        if (a.button == 2) {
            var r = confirm("�Ƿ�Ҫɾ�������ߣ�");
            if (r == true) {
                lineDelete(this);
            };
        };
    };

    /*����ӹ������ߵ��¼�*/
    function lineOver() {
        this.strokecolor = "red";
        this.strokeweight = 3;
    };
    function lineOut() {
        this.strokecolor = _this.linecolor;
        this.strokeweight = 1;
    };

    //ɾ�������Լ�����������������������
    function componentDelete(c) {
        var i, j;
        var comp = _this.findById(c.id);
        for (i = 0; i < comp.connection.length; i++) {
            for (j = 0; j < comp.connection[i].length; ) {
                lineDelete(comp.connection[i][j][0]);
            };
        };
        deleteById(c.id);
        c.removeNode(true);

    };

    //�һ�ɾ���������������ߵ�����¼�
    function deleteC(a) {
        if (!a) a = window.event;
        if (a.button == 2) {
            var r = confirm("�Ƿ�Ҫɾ��Ԫ�������������ߣ�");
            if (r == true) {
                componentDelete(this);
            };
        };
    };


    //˫��������ʾ�������ŵ�ֵ
    function showPinValue() {
        var s = "";
        var comp = _this.findById(this.id);
        var len = comp.pinValue.length;
        var w = 220;
        var i;
        if (len > 20) w = len*10;
        for (i = len - 1; i >= len / 2; i--) {
            s = s + comp.pinValue[i] + "&nbsp;&nbsp;&nbsp;";
        };
        s = s + "<br/>";
        for (i = len - 1; i >= len / 2; i--) {
            if (i < 10) {
                s = s + i + "&nbsp;&nbsp;&nbsp;";
            } else {
                s = s + i + " ";
            };
        };
        s = s + "<br/>";
        for (i = 0; i < len / 2; i++) {
            if (i < 10) {
                s = s + i + "&nbsp;&nbsp;&nbsp;";
            } else {
                s = s + i + " ";
            };
        };
        s = s + "<br/>";
        for (i = 0; i < len / 2; i++) {
            s = s + comp.pinValue[i] + "&nbsp;&nbsp;&nbsp;";
        };        
      
        s = "<p>" + s + "</p>";
        dialog.innerHTML =s;
        $("#dialog").dialog({
            modal: true,
            height: 220,
            width: w,
            buttons: [
                {
                    text: "OK",
                    click: function () {
                        $(this).dialog("close");
                    }
                }
            ]
        });

    };


    /*���ص���굥���¼�*/
    function switchClick(a) {
        var moveFlag = false;
        var d = document;
        var me = this;

        $(this).bind("mousemove",mm);
        $(this).bind("mouseup", mup);
         
        function mm() {
            moveFlag = true;
        };

        function mup() {
            if (!moveFlag) {
                var imgSrc = me.style.backgroundImage;            
                var c = _this.findById(me.id);
                if (imgSrc == "url(\"./img/switchL.gif\")" || imgSrc=="url(./img/switchL.gif)") {
                    me.style.backgroundImage = "url(./img/switchH.gif)";
                };
                if (imgSrc == "url(\"./img/switchH.gif\")" || imgSrc=="url(./img/switchH.gif)") {
                    me.style.backgroundImage = "url(./img/switchL.gif)";                
                };
                if (cDispatch.runState == 1) {
                    cDispatch.sourceTrigger(c);
                } else {
                    c.input();
                };
            };

            $(me).unbind("mousemove", mm);
            $(me).unbind("mouseup", mup);
        };
    };
 
    /*��������������굥���¼�*/
    function singlePulseClick(a) {
        var moveFlag = false;
        var d = document;
        var me = this;

        $(this).bind("mousemove", mm);
        $(this).bind("mouseup", mup);

        function mm() {
            moveFlag = true;
        };

        function mup() {
            if (!moveFlag) {
                var c = _this.findById(me.id);
                if (cDispatch.runState == 1 && c.timer==null) {
                    cDispatch.sourceTrigger(c);
                };
            };

            $(me).unbind("mousemove", mm);
            $(me).unbind("mouseup", mup);
        };
    };

    this.linecolorchange = function (c) {
        var x = document.getElementsByClassName("line");
        for (var i = 0; i < x.length; i++) {
            x[i].strokecolor =c;
        };
    };

    this.deletecircuit = function () {
        var c;
        if ($("#power").attr("src") == "./img/poweron.png") {
            $("#power").attr("src", "./img/poweroff.png");
            cDispatch.powerOff();
        };

        for (var i = 0; _this.componentAll.length>0 ; i) {
            c = document.getElementById(_this.componentAll[i].id); 
            componentDelete(c);
        };
        
        this.count = 0;   //����������������ɾ����������������������id
        var targetPin = null;  //��������ʱ��Ŀ������
    };

   
};


