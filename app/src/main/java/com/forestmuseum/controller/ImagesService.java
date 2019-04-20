package com.forestmuseum.controller;

import com.forestmuseum.R;
import com.forestmuseum.entity.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xinzhao
 * @create 2019-04-18 15:37
 */
public class ImagesService {
    public static List<Image> allImages=getAllImages();
    public static Map<Integer, Image> imgs=getImgs();
    public static List<Integer> pic = getPic();
   private static List<Image> getAllImages() {
        List<Image> allImages = new ArrayList<>();
        allImages.add(new Image(R.drawable.pic_1, "孔子鸟","kongziniao", "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。", R.raw.kongziniao));
        allImages.add(new Image(R.drawable.pic_2,"巨型马陆","juxingmalu" ,"巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。", R.raw.juxingmalu));
        allImages.add(new Image(R.drawable.pic_3,"东北野牛" + "披毛犀","dongbeiyeniupimaoxi", "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝", R.raw.dongbeiyeniu));
        allImages.add(new Image(R.drawable.pic_4,"鹦鹉螺", "yinwuluo","我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。", R.raw.yignwuluo));
        allImages.add(new Image(R.drawable.pic_5,"唐冠螺", "tangguanluo","前方玻璃展柜中的展品是一些海螺，中间最大的名叫唐冠螺，因为形状像唐朝僧人的帽子而得名。唐冠螺是“四大名螺”之一。四大名螺包括万宝螺、唐冠螺、凤尾螺和和鹦鹉螺。", R.raw.tangguanluo));
        allImages.add(new Image(R.drawable.pic_6,"化石森林", "huashisenlin","这些木化石，形为木材、质为石材，外形奇特，精美非常，可以说是大自然赠予人们一个极其精致的礼物。它们多保存了原来木材的结构形态，表面经打磨抛光以后，可以清晰地见到原来树木的结构特征，这对科学家们研究古代植物变迁和树木进化等具有极其重要的科学意义", R.raw.huashisenlin));
        allImages.add(new Image(R.drawable.pic_7,"欢乐女神蝶", "huanlenvshendie","", R.raw.huanlenushendie));
        allImages.add(new Image(R.drawable.pic_8,"鹤类", "helei","在前面的这三只是鹤科鹤属的鸟类。均为国家二级保护动物。第一的名字叫做白枕鹤，大家仔细观察它身上的羽毛，它的脚是粉红色的，颈部有灰有白，前灰后白，面部红色，它非常的漂亮，但是现在野生白枕鹤只剩下4900～5400 只。"+
 "\n    旁边这只是灰鹤，世界上现在又15中鹤类，灰鹤是分布最广的一种。"+
  "\n    最小的这一支鹤是蓑羽鹤，它是世界现存 15 种鹤中体型最小的一种。它不仅体型小，而且蓑羽鹤性格羞怯，不善与其他鹤类合群，喜欢独处。它举止娴雅、稳重端庄，就像我们常说的大家闺秀，所以又名“闺秀鹤”。", R.raw.helei));
        allImages.add(new Image(R.drawable.pic_9,"花面狸", "huamianli","旁边这只是花面狸，它还有一个名字，叫果子狸。果子狸是我国稀有“山珍”，有一句俗语便说“山中好吃果子狸，水里好吃白鳝鱼”。果子狸的针毛是制作高档毛笔和画笔的原料。它的脂肪在化妆品生产中是难得的高级原料，还是医治烫伤的良药。", R.raw.huamianli));
        allImages.add(new Image(R.drawable.pic_10,"华南虎", "huananhu","这一只老虎是华南虎，还记得我们之前说过东北虎吗？华南虎和东北虎的区别是体型和颜色。华南虎的体型要比东北虎小一点， 毛色要比东北虎深一点。但是，对于是否还存在野生的华南虎这个问题，我们现在仍还不确定。", R.raw.huananhu));
        allImages.add(new Image(R.drawable.pic_11,"东北虎", "dongbeihu","我们现在置身于一片茂密的东北地区森林之中，快看，你的右边有几头凶猛又不失可爱的东北虎！我是如何辨别这是东北虎呢？因为东北虎它头圆耳短，耳背呈黑色但却有一个十分显著的白斑。东北虎的虎龄一般是20至25岁。但是由于近年来森林的不断被砍伐，以及人类对东北虎的大肆猎杀，导致东北地区野生东北虎的数量已经不足 20 只。目前国家已将东北虎列为一级保护动物，大家今后一定要多多爱护东北虎，关注东北虎。 这边是一只正在哺育幼仔的东北虎，东北虎一胎可产子 1—5 只，通常是两只。", R.raw.dongbeihu));
        allImages.add(new Image(R.drawable.pic_12,"马来熊", "malaixiong","旁边这一只非常可爱的熊是马来熊，它是熊科动物里面体型最小的一种。成年马来熊的体重只能达到120斤左右。", R.raw.malaxiong));
        allImages.add(new Image(R.drawable.pic_13,"小熊猫", "xiaoxiongmao","这些是小熊猫，我们可以发现，小熊猫和大熊猫长得完全不一样，的确，其实它们是两种动物。在小熊猫旁边的是浣熊。小熊猫和浣熊有一个相同的非常有趣的习性，那就是它们会像我们一样，将食物清洗之后再食用。", R.raw.xiaoxiongmao));
        allImages.add(new Image(R.drawable.pic_14,"大熊猫", "daxiongmao","我相信每一位小朋友都能叫出它们的名字——大熊猫。大熊猫是众所周知的中国的一个国宝。它们是一种远古时期遗存下来的一种动物。我们都知道竹子是大熊猫平时最喜欢吃的食物。但是在远古时代，大熊猫并不是吃竹子的， 大家一定不知道，其实很久以前，大熊猫是吃肉的。可是这种笨重的肉食性动物竞争不过其他的肉食性动物。所以它们选择了一种其他动物不会吃的植物——竹子作为自己的食物来源。大熊猫每胎可以生宝宝1到2只。当一个大熊猫生产出两只熊猫宝宝，她会选择其中强壮的一只带走，然后抛弃弱小的一只。看起来熊猫妈妈好像非常的残忍，但实际上是因为大熊猫宝宝体重只有150克，小于一只成年大熊猫体重的千分之一。大熊猫宝宝的身体尚未发育完全，所以很难生存。大熊猫妈妈这么做是为了能够确保能有一只宝宝得到生息繁衍。大熊猫曾经是濒危保护动物，很幸运的是，在林业工作者和科研工作者的努力下，现在大熊猫的保护等级已经降到了易危。现在野生大熊猫的数量已经超过了1800多只。", R.raw.daxiongmao));
        allImages.add(new Image(R.drawable.pic_15,"金雕", "jindiao","上面这一只眼神犀利的动物是金雕，它是北半球上一种广为人知的猛禽。金雕的飞行敏捷有力，非常善于翱翔和滑翔，常在高空中一边呈直线或圆圈状盘旋，一边俯视地面寻找猎物，两翅上举“V”状，用柔软而灵活的两翼和尾的变化来调节飞行的方向、高度、 速度和飞行姿势。发现目标后，常以每小时 300 千米的速度从天而降，并在最后一刹那嘎然止住扇动的翅膀，然后牢牢地抓住猎物的头部，将利爪戳进猎物的头骨，使其立即丧失性命。所以猎物可以说是很难掏出它的魔爪了。", R.raw.jindiao));
        allImages.add(new Image(R.drawable.pic_16,"金丝猴", "jinsihou","这些就是非常有名的金丝猴了。在中国，除了我们现在看到的川金丝猴，还有其它两种金丝猴，分别是滇金丝猴和黔金丝猴。川金丝猴是三种金丝猴中非常好看的一种，因为它们拥有着满身金色的毛。", R.raw.jinsihou));
        allImages.add(new Image(R.drawable.pic_17,"蓝孔雀", "lankongque","这几种非常漂亮的鸟类大家一定认识，它们是孔雀的一种，叫做蓝孔雀。你们猜一猜那一只是雄性？其实啊，这一只羽毛艳丽的是雄蓝孔雀，其他的是雌蓝孔雀。雄性的蓝孔雀能够展开自己的尾巴开屏，非常的美丽。", R.raw.lankongque));
        allImages.add(new Image(R.drawable.pic_18,"猎隼", "liesun","接下来这只看起来非常凶悍的是深受蒙古国人民喜爱的猛禽猎隼，国家一级保护动物。2012 年10 月，蒙古国政府决定，将猎隼确定为蒙古国“国鸟”， 蒙古国官方数据显示，蒙古国 境内现存猎隼约 6800 只。", R.raw.liesun));
        allImages.add(new Image(R.drawable.pic_19,"貉", "he","大家看到的是貉。北方貉在冬季有蛰眠习性，但与真正的冬眠不同，呈昏睡状态，代谢活动并不停止。貉的毛皮非常珍贵，也经常被人们利用，毛长绒厚,板质轻韧,拔去针毛的绒皮为上好制裘原料。针毛弹性好，适于制造画笔。", R.raw.he));
        allImages.add(new Image(R.drawable.pic_20,"扭角羚", "niujiaoling","下面这一只是扭角羚，中国的四大国宝动物之一。就像大熊猫一样，扭角羚只生活在中国。但是它却没有大熊猫那么幸运，其野生数量仍非常的稀少，现在还是一种濒危保护动物。我国的四大国宝分别是大熊猫、扭角羚、朱鹮和金丝猴。", R.raw.niujiaoling));
        allImages.add(new Image(R.drawable.pic_21,"秃鹫", "tujiu","接下来我们看见的这一支长相很不友好的动物是秃鹫，又叫秃鹰、座山雕，泛指一类以食腐肉为生的大型猛禽，也是国家二级保护动物。成年秃鹫头部有褐色绒羽，后头羽色稍淡，颈裸出。秃鹫有一个特点，就是脖子的基部长了一圈比较长的羽毛，像我们吃西餐的时候所用的餐巾一样，可以防止食尸时弄脏身上的羽毛。", R.raw.tujiu));
        allImages.add(new Image(R.drawable.pic_22,"鼯鼠", "wushu","鼯鼠，又称为飞鼠，但人们这么称它们并不是因为它们会飞，而是因为它们能在树、陆中间滑翔。", R.raw.wushu));
        allImages.add(new Image(R.drawable.pic_23,"犀牛", "xiniu","首先我们看见的这个体型非常大的大型动物是非洲犀，体大威武，形态奇特，是体形最大的犀牛，也是仅次于非洲象和亚洲象的第三大陆生脊椎动物，堪称“犀牛之王”。", R.raw.feizhouxi));
        allImages.add(new Image(R.drawable.pic_24,"岩羊", "yanyang","现在我们看见的是一只岩羊，从它的名字我们就可以看出，它们喜爱攀登岩峰，它们是国家二级保护动物。", R.raw.yanyang));

        return allImages;
    }
    private static List<Integer> getPic() {
        List<Integer> pic = new ArrayList<>();
        for(int i=0; i<allImages.size(); i++){
            pic.add(allImages.get(i).getId());
        }
        return  pic;
    }

    public static List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(int i=0; i<allImages.size(); i++){
            names.add(allImages.get(i).getTitle());
        }
        return names;
    }

    /**
     *创建资源
     * @return
     */

    public  static Map<Integer, Image> getImgs(){
        Map<Integer, Image> imgs = new HashMap<>();
        for(int i=0; i<allImages.size(); i++){
            imgs.put(allImages.get(i).getId(), allImages.get(i));
        }
        return imgs;
    }

    public static int getIdByName(String name){
        int id=-1;
        for(Image i : allImages){
            if (i.getTitle().equals(name)) {
                id = i.getId();
            }
        }
        return id;
    }

    public static int getIdByPositon(int p){
        return allImages.get(p).getId();
    }
}
