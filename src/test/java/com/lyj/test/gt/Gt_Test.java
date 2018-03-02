//package com.lyj.test.gt;
///**
// * @time:2018年2月28日下午2:15:01
// * @author:longyujia 
// * @emial: longyujia@knowlegene.com
// */
//
//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptException;
//
//public class Gt_Test {
//    private ScriptEngine scriptEngine;
//
//    public Gt_Test() {
//        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//        this.scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
//    }
//
//    public String challenge(String resp){
//        resp = resp.substring(8);
//        String tmp[] = resp.split("</script");
//        resp = tmp[0];
//        resp = resp.replace("eval(y.replace", "var aaa=(y.replace");
//        resp = resp + "aaa=aaa.replace("h=document.createElement('div');","");aaa=aaa.replace("h.innerHTML='<a href=\\\'/\\\'","");\n" +
//                "aaa=aaa.replace(">x</a>';","");aaa=aaa.replace("h=h.firstChild.href;","h='http://www.gsxt.gov.cn/';");aaa=aaa.replace("while(window._phantom||window.__phantomas){};","");bbb=aaa.split("setTimeout");\n" +
//                "    aaa=bbb[0]+"return dc;}}";\n" +
//                "    aaa=aaa.replace("var l=","{fa:");\n" +
//                "  var ffa=eval("("+aaa+")");\n" +
//                "    var fffa=ffa.fa();";
//
//
//        System.out.println(resp);
//        String script = resp;
//        try {
//            scriptEngine.eval(script);
//        } catch (ScriptException e) {
//            return e.getMessage();
//        }
//        String bbb = (String) scriptEngine.get("fffa");
//        System.out.println(bbb);
//        return bbb;
//    }
//    public String getImageGif(String resp){
//        String script="function dd(){var json="+resp+";return json.map( function(item){ return String.fromCharCode(item);}).join('');}" +
//                "var ggg=dd();";
//
//        try {
//            scriptEngine.eval(script);
//        } catch (ScriptException e) {
//            return e.getMessage();
//        }
//        String bbb = (String) scriptEngine.get("ggg");
//        return bbb;
//    }
//    public static void main(String[] s){
//        new GovTest().challenge("<script>var x="while@div@substr@setTimeout@26@window@9@5@03@location@cookie@String@l@dc@37@GMT@a@href@if@0@length@__jsl_clearance@4@toLowerCase@_phantom@var@f@challenge@1517192797@reverse@match@085@join@3@cd@Mon@catch@fromCharCode@charAt@firstChild@Path@createElement@document@Expires@29@innerHTML@addEventListener@__phantomas@i@eval@captcha@h@replace@x@https@Jan@for@try@r@2@function@18@return@1500@e@false@DOMContentLoaded@else@attachEvent@onreadystatechange".replace(/@*$/,"").split("@"),y="1a d=3d(){1(6.19||6.30){};1a 23,e='16=1d.20|14|';1a 1b=[3d(36){3f 32('c.26('+36+')')},(3d(){1a 34=2b.2a('2');34.2e='<11 12=\\\'/\\\'>36</11>';34=34.28.12;1a 3b=34.1f(/37?:\\\\/\\\\//)[14];34=34.3(3b.15).18();3f 3d(36){39(1a 31=14;31<36.15;31++){36[31]=34.27(36[31])};3f 36.21('')}})()];23=[[[3c+8]+[-~-~(+[])],(22+[]+[[]][~~[]])+[3c+8],(8+[[]][~~[]])+[(+[])],[3c+8]+[(+[])],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[(+[])],(8+[[]][~~[]])+[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]],(8+[[]][~~[]])+[3c+8],[3c+8]+[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]],(22+[]+[[]][~~[]])+[3c+8],(8+[[]][~~[]])+[(+[])],[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]],[3c+8]+[(+[])],[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+(8+[[]][~~[]]),(-~(+[])+[[]][~~[]])+[(+[])]+[17],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+(8+[[]][~~[]]),(7+[])+[(+[])]],[[(+[])]],[(-~(+[])+[[]][~~[]])+[(+[])]+[-~-~(+[])],(8+[[]][~~[]])+[(+[])],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+(22+[]+[[]][~~[]])],[[3c+8]],[[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[-~-~(+[])]],[[(+[])],[17],[17]],[[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[17],(-~(+[])+[[]][~~[]])+(-~(+[])+[[]][~~[]])+[17],(-~(+[])+[[]][~~[]])+[(+[])]+(7+[]),[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]],[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+(8+[[]][~~[]]),(22+[]+[[]][~~[]])+[3c+8],(8+[[]][~~[]])+(-~(+[])+[[]][~~[]]),[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]]];39(1a 31=14;31<23.15;31++){23[31]=1b.1e()[(-~(+[])+[[]][~~[]])](23[31])};23=23.21('');e+=23;4('a.12=a.12.35(/[\\\\?|&]33-1c/,\\\'\\\')',40);2b.b=(e+';2c=24, 2d-38-3e 9:5:f 10;29=/;');};13((3d(){3a{3f !!6.2f;}25(41){3f 42;}})()){2b.2f('43',d,42);}44{2b.45('46',d);}",z=0,f=function(x,y){var a=0,b=0,c=0;x=x.split("");y=y||99;while((a=x.shift())&&(b=a.charCodeAt(0)-77.5))c=(Math.abs(b)<13?(b+48.5):parseInt(a,36))+y*c;return c},g=y.match(/\\b\\w+\\b/g).sort(function(x,y){return f(x)-f(y)}).pop();while(f(g,++z)-x.length){};eval(y.replace(/\\b\\w+\\b/g, function(y){return x[f(y,z)-1]}));</script>");
//    }
//}
