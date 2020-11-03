package com.example.usercenter.main_and_cotegory.fragment.entity;

import java.util.List;

public class FenLeiBean {
    /**
 * code : 200
 * data : [{"id":5470,"category_id":16,"parent_id":0,"category_name":"女装/女士精品"},{"id":5471,"category_id":30,"parent_id":0,"category_name":"男装"},{"id":5472,"category_id":50008165,"parent_id":0,"category_name":"童装/童鞋/孕妇装"},{"id":5473,"category_id":50006842,"parent_id":0,"category_name":"箱包皮具/热销女包/男包"},{"id":5474,"category_id":1801,"parent_id":0,"category_name":"美容护肤/美体/精油"},{"id":5475,"category_id":21,"parent_id":0,"category_name":"居家日用/厨房餐饮/卫浴洗浴"},{"id":5476,"category_id":50002766,"parent_id":0,"category_name":"食品/茶叶/零食/特产"},{"id":5477,"category_id":50006843,"parent_id":0,"category_name":"女鞋"},{"id":5478,"category_id":1625,"parent_id":0,"category_name":"女士内衣/男士内衣/家居服"},{"id":5479,"category_id":2128,"parent_id":0,"category_name":"时尚家饰/工艺品/十字绣"},{"id":5480,"category_id":27,"parent_id":0,"category_name":"装潢/灯具/五金/安防/卫浴"},{"id":5481,"category_id":50010788,"parent_id":0,"category_name":"彩妆/香水/美发/工具"},{"id":5482,"category_id":50008090,"parent_id":0,"category_name":"3C数码配件市场"},{"id":5483,"category_id":26,"parent_id":0,"category_name":"汽车/配件/改装/摩托/自行车"},{"id":5484,"category_id":50008163,"parent_id":0,"category_name":"家纺/床品/地毯/布艺"},{"id":5485,"category_id":25,"parent_id":0,"category_name":"玩具/模型/娃娃/人偶"},{"id":5486,"category_id":50010404,"parent_id":0,"category_name":"服饰配件/皮带/帽子/围巾"},{"id":5487,"category_id":50010728,"parent_id":0,"category_name":"运动/瑜伽/健身/球迷用品"},{"id":5488,"category_id":33,"parent_id":0,"category_name":"书籍/杂志/报纸"},{"id":5489,"category_id":50011699,"parent_id":0,"category_name":"运动服/运动包/颈环配件"},{"id":5490,"category_id":50011740,"parent_id":0,"category_name":"流行男鞋"},{"id":5491,"category_id":23,"parent_id":0,"category_name":"古董/邮币/字画/收藏"},{"id":5492,"category_id":35,"parent_id":0,"category_name":"奶粉/尿片/母婴用品"},{"id":5493,"category_id":50007218,"parent_id":0,"category_name":"办公设备/文具/耗材"},{"id":5494,"category_id":50008164,"parent_id":0,"category_name":"家具/家具定制/宜家代购"},{"id":5495,"category_id":1705,"parent_id":0,"category_name":"饰品/流行首饰/时尚饰品"},{"id":5496,"category_id":50002768,"parent_id":0,"category_name":"个人护理/保健/按摩器材"},{"id":5497,"category_id":50008168,"parent_id":0,"category_name":"网络服务/电脑软件"},{"id":5498,"category_id":28,"parent_id":0,"category_name":"ZIPPO/瑞士军刀/眼镜"},{"id":5499,"category_id":11,"parent_id":0,"category_name":"电脑硬件/台式整机/网络设备"},{"id":5500,"category_id":50007216,"parent_id":0,"category_name":"鲜花速递/蛋糕配送/园艺花艺"},{"id":5501,"category_id":50005998,"parent_id":0,"category_name":"益智玩具/童车/童床/书包"},{"id":5502,"category_id":34,"parent_id":0,"category_name":"音乐/影视/明星/乐器"},{"id":5503,"category_id":50003754,"parent_id":0,"category_name":"网店装修/物流快递/图片存储"},{"id":5504,"category_id":50011397,"parent_id":0,"category_name":"珠宝/钻石/翡翠/黄金"},{"id":5505,"category_id":29,"parent_id":0,"category_name":"宠物/宠物食品及用品"},{"id":5506,"category_id":2813,"parent_id":0,"category_name":"成人用品/避孕用品/情趣内衣"},{"id":5507,"category_id":40,"parent_id":0,"category_name":"腾讯QQ专区"},{"id":5508,"category_id":14,"parent_id":0,"category_name":"数码相机/摄像机/图形冲印"},{"id":5509,"category_id":50008907,"parent_id":0,"category_name":"IP卡/网络电话/手机号码"},{"id":5510,"category_id":99,"parent_id":0,"category_name":"网络游戏点卡"},{"id":5511,"category_id":50011972,"parent_id":0,"category_name":"影音电器"},{"id":5512,"category_id":50012082,"parent_id":0,"category_name":"厨房电器"},{"id":5513,"category_id":50012100,"parent_id":0,"category_name":"生活电器"},{"id":5514,"category_id":50010388,"parent_id":0,"category_name":"运动鞋"},{"id":5515,"category_id":50011665,"parent_id":0,"category_name":"网游装备/游戏币/帐号/代练"},{"id":5516,"category_id":20,"parent_id":0,"category_name":"电玩/配件/游戏/攻略"},{"id":5517,"category_id":50012164,"parent_id":0,"category_name":"闪存卡/U盘/移动存储"},{"id":5518,"category_id":50005700,"parent_id":0,"category_name":"品牌手表/流行手表"},{"id":5519,"category_id":50004958,"parent_id":0,"category_name":"移动/联通/小灵通充值中心"},{"id":5520,"category_id":2203,"parent_id":0,"category_name":"户外/登山/野营/涉水"},{"id":5521,"category_id":1512,"parent_id":0,"category_name":"手机"},{"id":5522,"category_id":50011949,"parent_id":0,"category_name":"旅游度假/打折机票/特惠酒店"},{"id":5523,"category_id":50008075,"parent_id":0,"category_name":"演出/旅游/吃喝玩乐折扣券"},{"id":5524,"category_id":1201,"parent_id":0,"category_name":"MP3/MP4/iPod/录音笔"},{"id":5525,"category_id":1101,"parent_id":0,"category_name":"笔记本电脑"},{"id":5526,"category_id":50011150,"parent_id":0,"category_name":"其它"},{"id":5527,"category_id":50012472,"parent_id":0,"category_name":"保健食品"},{"id":5528,"category_id":50012081,"parent_id":0,"category_name":"国货精品手机"},{"id":5529,"category_id":0,"parent_id":0,"category_name":"淘客根目录"}]
 * msg : 操作成功
 */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", category_id=" + category_id +
                    ", parent_id=" + parent_id +
                    ", category_name='" + category_name + '\'' +
                    '}';
        }

        /**
         * id : 5470
         * category_id : 16
         * parent_id : 0
         * category_name : 女装/女士精品
         */

        private int id;
        private int category_id;
        private int parent_id;
        private String category_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }
    }
}
