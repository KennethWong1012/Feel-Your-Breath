package ict.mgame.a5303_5308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizData {

    private static List<StoryTheme> storyThemes = null;

    public static List<StoryTheme> getStoryThemes() {
        if (storyThemes == null) {
            storyThemes = new ArrayList<>();
            storyThemes.add(createTheme1());
            storyThemes.add(createTheme2());
            storyThemes.add(createTheme3());
            storyThemes.add(createTheme4());
            storyThemes.add(createTheme5());
            storyThemes.add(createTheme6());
            storyThemes.add(createTheme7());
        }
        return storyThemes;
    }

    private static StoryTheme createTheme1() {
        String title = "魔法森林的冒險";
        String story = "你走進一個閃閃發光的魔法森林，樹木會說話，動物們邀請你一起探索秘密寶藏！";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("會說話的樹木送你一片發光的葉子，你心裡想？", Arrays.asList(
                        new QuizModels.Answer("太棒了！我要好好收藏它。", Mood.HAPPY),
                        new QuizModels.Answer("要是我的朋友也能看到就好了。", Mood.SAD),
                        new QuizModels.Answer("為什麼只有一片？真小氣。", Mood.ANGER),
                        new QuizModels.Answer("這葉子會不會有魔法詛咒？", Mood.FEAR),
                        new QuizModels.Answer("我不配收到這麼好的禮物。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("我該怎麼回禮才對？", Mood.ANXIETY),
                        new QuizModels.Answer("這葉子黏黏的，我不喜歡。", Mood.DISGUST)
                )),
                new QuizModels.Question("一隻小鹿請你幫它找回家的路，你會？", Arrays.asList(
                        new QuizModels.Answer("開心答應，覺得自己能幫忙真好。", Mood.HAPPY),
                        new QuizModels.Answer("想到小鹿迷路了，有點難過。", Mood.SAD),
                        new QuizModels.Answer("覺得它打擾了你的探險。", Mood.ANGER),
                        new QuizModels.Answer("擔心自己也迷路。", Mood.FEAR),
                        new QuizModels.Answer("怕自己沒有能力幫助它。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("緊張地想著萬一找不到怎麼辦。", Mood.ANXIETY),
                        new QuizModels.Answer("不想碰觸陌生的動物。", Mood.DISGUST)
                )),
                new QuizModels.Question("森林深處傳來奇怪的聲音，你的反應是？", Arrays.asList(
                        new QuizModels.Answer("好奇又興奮，想過去看看。", Mood.HAPPY),
                        new QuizModels.Answer("感覺那聲音聽起來很孤單。", Mood.SAD),
                        new QuizModels.Answer("對這種嚇人的聲音感到生氣。", Mood.ANGER),
                        new QuizModels.Answer("立刻停下腳步，不敢前進。", Mood.FEAR),
                        new QuizModels.Answer("一定是怪物，我應該打不過。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("心跳加速，不知道該怎麼辦。", Mood.ANXIETY),
                        new QuizModels.Answer("真討厭這種詭異的聲音。", Mood.DISGUST)
                )),
                new QuizModels.Question("你發現一個用藤蔓盪過河岸的機會，你會？", Arrays.asList(
                        new QuizModels.Answer("覺得太刺激了，立刻嘗試！", Mood.HAPPY),
                        new QuizModels.Answer("盪過去的時候，有點想哭。", Mood.SAD),
                        new QuizModels.Answer("氣自己為什麼不會飛。", Mood.ANGER),
                        new QuizModels.Answer("緊緊抓住藤蔓，不敢動。", Mood.FEAR),
                        new QuizModels.Answer("別人一定做得比我好。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("反复想著藤蔓會不會斷掉。", Mood.ANXIETY),
                        new QuizModels.Answer("藤蔓看起來好髒，不想碰。", Mood.DISGUST)
                )),
                new QuizModels.Question("動物們為你舉辦了一場歡迎派對，你感覺？", Arrays.asList(
                        new QuizModels.Answer("非常開心，和大家一起跳舞。", Mood.HAPPY),
                        new QuizModels.Answer("派對總會結束，有點傷感。", Mood.SAD),
                        new QuizModels.Answer("不喜歡它們安排的遊戲。", Mood.ANGER),
                        new QuizModels.Answer("被這麼多動物圍觀，好緊張。", Mood.FEAR),
                        new QuizModels.Answer("我不值得大家為我這樣做。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心自己在派對上出錯。", Mood.ANXIETY),
                        new QuizModels.Answer("不喜歡派對上的食物。", Mood.DISGUST)
                )),
                new QuizModels.Question("冒險結束了，你必須離開魔法森林，你會？", Arrays.asList(
                        new QuizModels.Answer("期待下一次再來玩。", Mood.HAPPY),
                        new QuizModels.Answer("捨不得離開，有點想哭。", Mood.SAD),
                        new QuizModels.Answer("生氣為什麼不能留在這裡。", Mood.ANGER),
                        new QuizModels.Answer("怕出去後就忘記這裡了。", Mood.FEAR),
                        new QuizModels.Answer("森林沒有我也會一樣快樂吧。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心以後再也進不來了。", Mood.ANXIETY),
                        new QuizModels.Answer("終於可以離開這麻煩的地方了。", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme2() {
        String title = "太空船探險";
        String story = "你駕駛一艘太空船，飛向未知星球，那裡有友善的外星人和閃爍的星星等著你！";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("太空船即將降落在從未有人類去過的星球，你感到？", Arrays.asList(
                        new QuizModels.Answer("無比興奮，準備第一個衝出去！", Mood.HAPPY),
                        new QuizModels.Answer("想到自己是孤單一人，有點感傷。", Mood.SAD),
                        new QuizModels.Answer("對控制台緩慢的速度感到不耐煩。", Mood.ANGER),
                        new QuizModels.Answer("害怕門後會有未知的危險。", Mood.FEAR),
                        new QuizModels.Answer("我可能是最不適合執行這任務的人。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心飛船的空氣系統會不會故障。", Mood.ANXIETY),
                        new QuizModels.Answer("覺得外星可能充滿細菌。", Mood.DISGUST)
                )),
                new QuizModels.Question("一個長相奇特的外星人向你伸出手，你會？", Arrays.asList(
                        new QuizModels.Answer("高興地與它握手，交新朋友。", Mood.HAPPY),
                        new QuizModels.Answer("它的手看起來很孤單，讓我難過。", Mood.SAD),
                        new QuizModels.Answer("不喜歡它未經允許就靠近。", Mood.ANGER),
                        new QuizModels.Answer("害怕它會傷害我，後退一步。", Mood.FEAR),
                        new QuizModels.Answer("我的手和它不一樣，真糟糕。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("猶豫著該不該伸手。", Mood.ANXIETY),
                        new QuizModels.Answer("它看起來黏黏的，不想碰。", Mood.DISGUST)
                )),
                new QuizModels.Question("外星食物看起來像一團發光的果凍，你會？", Arrays.asList(
                        new QuizModels.Answer("太酷了！我要嘗嘗看！", Mood.HAPPY),
                        new QuizModels.Answer("懷念起地球上的食物。", Mood.SAD),
                        new QuizModels.Answer("為什麼沒有正常的食物？", Mood.ANGER),
                        new QuizModels.Answer("怕吃了身體會過敏。", Mood.FEAR),
                        new QuizModels.Answer("連吃東西我都這麼膽小。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心吃了會肚子痛。", Mood.ANXIETY),
                        new QuizModels.Answer("看起來真噁心，不想試。", Mood.DISGUST)
                )),
                new QuizModels.Question("你發現自己忘記了回地球的路，你的想法是？", Arrays.asList(
                        new QuizModels.Answer("太好了，可以繼續探險！", Mood.HAPPY),
                        new QuizModels.Answer("我可能永遠見不到家人了。", Mood.SAD),
                        new QuizModels.Answer("氣自己為什麼這麼粗心。", Mood.ANGER),
                        new QuizModels.Answer("完蛋了，我會在太空漂流。", Mood.FEAR),
                        new QuizModels.Answer("我總是搞砸重要的事。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("不斷想著各種可怕的後果。", Mood.ANXIETY),
                        new QuizModels.Answer("討厭這種失控的感覺。", Mood.DISGUST)
                )),
                new QuizModels.Question("外星朋友想學習地球的遊戲，你會？", Arrays.asList(
                        new QuizModels.Answer("開心地教它們玩躲貓貓。", Mood.HAPPY),
                        new QuizModels.Answer("玩的時候有點想家。", Mood.SAD),
                        new QuizModels.Answer("它們老是學不會，真讓人生氣。", Mood.ANGER),
                        new QuizModels.Answer("怕它們不喜歡地球的遊戲。", Mood.FEAR),
                        new QuizModels.Answer("我解釋得一點都不清楚。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心遊戲規則太複雜。", Mood.ANXIETY),
                        new QuizModels.Answer("不想和它們分享地球的事。", Mood.DISGUST)
                )),
                new QuizModels.Question("任務結束，你被當成英雄歡迎，你覺得？", Arrays.asList(
                        new QuizModels.Answer("真是太光榮了！", Mood.HAPPY),
                        new QuizModels.Answer("熱鬧過後，感覺空虛。", Mood.SAD),
                        new QuizModels.Answer("他們根本不了解真正的過程。", Mood.ANGER),
                        new QuizModels.Answer("怕大家對我期望太高。", Mood.FEAR),
                        new QuizModels.Answer("我根本不是真正的英雄。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心下次做不到這麼好。", Mood.ANXIETY),
                        new QuizModels.Answer("厭倦了這些虛偽的歡迎。", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme3() {
        String title = "海底王國之旅";
        String story = "你變成一條小魚，游進神秘海底王國，那裡有會說話的珊瑚和閃亮珍珠！";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("當海豚邀請你賽跑時，你會？", Arrays.asList(
                        new QuizModels.Answer("太好玩了！我一定能贏！", Mood.HAPPY),
                        new QuizModels.Answer("牠會不會是因為孤單才找我？", Mood.SAD),
                        new QuizModels.Answer("為什麼牠一副比我快的樣子？", Mood.ANGER),
                        new QuizModels.Answer("怕游太快會撞到東西。", Mood.FEAR),
                        new QuizModels.Answer("我游得太難看，不敢比。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心比賽中途會抽筋。", Mood.ANXIETY),
                        new QuizModels.Answer("不想在渾濁的水裡比賽。", Mood.DISGUST)
                )),
                new QuizModels.Question("你看到發光水母在跳舞，你的反應是？", Arrays.asList(
                        new QuizModels.Answer("驚喜地加入它們的舞會！", Mood.HAPPY),
                        new QuizModels.Answer("它們的光讓我感到寂寞。", Mood.SAD),
                        new QuizModels.Answer("光太刺眼了，真不舒服。", Mood.ANGER),
                        new QuizModels.Answer("怕被水母螫到。", Mood.FEAR),
                        new QuizModels.Answer("我的舞姿一定很難看。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("靠太近會不會有危險？", Mood.ANXIETY),
                        new QuizModels.Answer("它們看起來滑溜溜的，真噁心。", Mood.DISGUST)
                )),
                new QuizModels.Question("章魚送你一個泡泡禮物，你會？", Arrays.asList(
                        new QuizModels.Answer("開心收下，覺得好特別！", Mood.HAPPY),
                        new QuizModels.Answer("泡泡總會破掉，像美夢一樣。", Mood.SAD),
                        new QuizModels.Answer("為什麼送這麼容易破的東西？", Mood.ANGER),
                        new QuizModels.Answer("怕泡泡裡面有怪東西。", Mood.FEAR),
                        new QuizModels.Answer("我不配收到禮物。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心弄破它會讓章魚不高興。", Mood.ANXIETY),
                        new QuizModels.Answer("泡泡有腥味，我不喜歡。", Mood.DISGUST)
                )),
                new QuizModels.Question("海底城堡的大門關著，你會？", Arrays.asList(
                        new QuizModels.Answer("興奮地敲門，期待誰來開門！", Mood.HAPPY),
                        new QuizModels.Answer("門關著，感覺自己被拒絕了。", Mood.SAD),
                        new QuizModels.Answer("誰把門關起來？真可惡！", Mood.ANGER),
                        new QuizModels.Answer("怕門後有可怕的守衛。", Mood.FEAR),
                        new QuizModels.Answer("我這種小魚不配進去。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("猶豫要不要按門鈴。", Mood.ANXIETY),
                        new QuizModels.Answer("門上都是藻類，真髒。", Mood.DISGUST)
                )),
                new QuizModels.Question("鯨魚唱起搖籃曲，你的感覺是？", Arrays.asList(
                        new QuizModels.Answer("好好聽，感覺好幸福！", Mood.HAPPY),
                        new QuizModels.Answer("歌聲讓我想媽媽了。", Mood.SAD),
                        new QuizModels.Answer("聲音太大了，好吵！", Mood.ANGER),
                        new QuizModels.Answer("怕巨大的聲音會震傷我。", Mood.FEAR),
                        new QuizModels.Answer("我永遠唱不了這麼好。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心鯨魚是不是在求救？", Mood.ANXIETY),
                        new QuizModels.Answer("不喜歡這種低沉的共鳴。", Mood.DISGUST)
                )),
                new QuizModels.Question("旅程結束，你變回人類，你的想法是？", Arrays.asList(
                        new QuizModels.Answer("海底世界真是太美妙了！", Mood.HAPPY),
                        new QuizModels.Answer("捨不得離開魚兒朋友。", Mood.SAD),
                        new QuizModels.Answer("氣自己沒多撿些珍珠。", Mood.ANGER),
                        new QuizModels.Answer("怕剛才的經歷只是一場夢。", Mood.FEAR),
                        new QuizModels.Answer("我還是當人類比較習慣。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心海洋會不會被污染。", Mood.ANXIETY),
                        new QuizModels.Answer("全身濕黏的感覺真不舒服。", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    // ... The other themes (4, 5, 6, 7) are added similarly
    // Due to length, I'll show the pattern and you can fill in the rest.
    // Let's add Theme 4 as a final example.

    private static StoryTheme createTheme4() {
        String title = "雲端城堡探險";
        String story = "你乘著氣球飛到雲端城堡，那裡有棉花糖雲和會笑的太陽，一切都輕飄飄的！";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("當雲朵變成軟綿綿的床，你會？", Arrays.asList(
                        new QuizModels.Answer("高興地在上面彈跳！", Mood.HAPPY),
                        new QuizModels.Answer("這麼舒服，卻只能短暫享受。", Mood.SAD),
                        new QuizModels.Answer("為什麼雲床這麼不牢固？", Mood.ANGER),
                        new QuizModels.Answer("怕會從雲縫中掉下去。", Mood.FEAR),
                        new QuizModels.Answer("我不該弄髒這麼白的雲。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心把雲床壓垮了。", Mood.ANXIETY),
                        new QuizModels.Answer("雲濕濕的，我不喜歡。", Mood.DISGUST)
                )),
                new QuizModels.Question("太陽對你眨眼睛，你的反應是？", Arrays.asList(
                        new QuizModels.Answer("驚喜地也對它眨眨眼！", Mood.HAPPY),
                        new QuizModels.Answer("它一個人在天上，好孤單。", Mood.SAD),
                        new QuizModels.Answer("光太強了，眼睛好痛！", Mood.ANGER),
                        new QuizModels.Answer("怕被它的熱度燒傷。", Mood.FEAR),
                        new QuizModels.Answer("我這麼平凡，它為什麼看我？", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("一直眨眼是不是有壞事發生？", Mood.ANXIETY),
                        new QuizModels.Answer("不喜歡這種被盯著的感覺。", Mood.DISGUST)
                )),
                new QuizModels.Question("你找到彩虹滑梯，你會？", Arrays.asList(
                        new QuizModels.Answer("太刺激了！我要滑一遍又一遍！", Mood.HAPPY),
                        new QuizModels.Answer("彩虹這麼美，消失了好可惜。", Mood.SAD),
                        new QuizModels.Answer("為什麼滑梯這麼陡？", Mood.ANGER),
                        new QuizModels.Answer("怕滑出去會飛到外太空。", Mood.FEAR),
                        new QuizModels.Answer("我這麼重，會不會壓壞彩虹？", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("猶豫要不要滑，怕有危險。", Mood.ANXIETY),
                        new QuizModels.Answer("不想弄濕自己的衣服。", Mood.DISGUST)
                )),
                new QuizModels.Question("風兒帶你飛高高，你的感覺是？", Arrays.asList(
                        new QuizModels.Answer("飛翔的感覺太自由了！", Mood.HAPPY),
                        new QuizModels.Answer("飛得再高，最後還是要下來。", Mood.SAD),
                        new QuizModels.Answer("風太大，吹得我頭好亂！", Mood.ANGER),
                        new QuizModels.Answer("怕風突然停下來。", Mood.FEAR),
                        new QuizModels.Answer("我控制不好飛行方向。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心會撞到小鳥或飛機。", Mood.ANXIETY),
                        new QuizModels.Answer("風中有沙子，好討厭。", Mood.DISGUST)
                )),
                new QuizModels.Question("城堡門前有謎語，你會？", Arrays.asList(
                        new QuizModels.Answer("真有趣，我喜歡動腦筋！", Mood.HAPPY),
                        new QuizModels.Answer("答錯了會不會永遠被關在外面？", Mood.SAD),
                        new QuizModels.Answer("誰出的這麼難的題目！", Mood.ANGER),
                        new QuizModels.Answer("怕答錯會被懲罰。", Mood.FEAR),
                        new QuizModels.Answer("我這麼笨，一定猜不出。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("萬一只有一次機會怎麼辦？", Mood.ANXIETY),
                        new QuizModels.Answer("覺得猜謎遊戲很無聊。", Mood.DISGUST)
                )),
                new QuizModels.Question("離開時，雲朵送你禮物，你會？", Arrays.asList(
                        new QuizModels.Answer("謝謝你！我會好好珍惜！", Mood.HAPPY),
                        new QuizModels.Answer("收到禮物，卻要說再見了。", Mood.SAD),
                        new QuizModels.Answer("為什麼不送更好一點的東西？", Mood.ANGER),
                        new QuizModels.Answer("怕禮物在回家路上消失。", Mood.FEAR),
                        new QuizModels.Answer("我不配收下這麼好的禮物。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心禮物會不會有代價？", Mood.ANXIETY),
                        new QuizModels.Answer("雲的禮物不過是水蒸氣罷了。", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme5() {
        String title = "動物嘉年華";
        String story = "你被邀請到動物嘉年華，獅子會跳舞，猴子會變魔術，大家一起開派對！";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("當獅子邀請你跳舞時，你會？", Arrays.asList(
                        new QuizModels.Answer("太榮幸了！馬上一起跳！", Mood.HAPPY),
                        new QuizModels.Answer("牠的舞步看起來有點悲傷。", Mood.SAD),
                        new QuizModels.Answer("牠的吼聲好大，真不舒服！", Mood.ANGER),
                        new QuizModels.Answer("怕牠不小心踩到我。", Mood.FEAR),
                        new QuizModels.Answer("我跳得不好，會害牠丟臉。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("緊張地想著舞步。", Mood.ANXIETY),
                        new QuizModels.Answer("不喜歡牠身上的味道。", Mood.DISGUST)
                )),
                new QuizModels.Question("猴子變出彩色氣球，你的反應是？", Arrays.asList(
                        new QuizModels.Answer("驚喜地拍手叫好！", Mood.HAPPY),
                        new QuizModels.Answer("氣球破了的話，猴子會難過吧。", Mood.SAD),
                        new QuizModels.Answer("只是氣球而已，沒什麼了不起。", Mood.ANGER),
                        new QuizModels.Answer("怕氣球突然爆炸。", Mood.FEAR),
                        new QuizModels.Answer("我連一個氣球都變不出來。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心氣球會被樹枝刺破。", Mood.ANXIETY),
                        new QuizModels.Answer("氣球的橡膠味好難聞。", Mood.DISGUST)
                )),
                new QuizModels.Question("你被選為派對隊長，你會？", Arrays.asList(
                        new QuizModels.Answer("太好了！我來帶大家玩遊戲！", Mood.HAPPY),
                        new QuizModels.Answer("當隊長意味著要承擔責任。", Mood.SAD),
                        new QuizModels.Answer("為什麼我要做這麼多事？", Mood.ANGER),
                        new QuizModels.Answer("怕大家不聽我的指揮。", Mood.FEAR),
                        new QuizModels.Answer("我沒有領導能力。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心把派對搞砸。", Mood.ANXIETY),
                        new QuizModels.Answer("真麻煩，我不想管別人。", Mood.DISGUST)
                )),
                new QuizModels.Question("食物桌有奇怪形狀點心，你會？", Arrays.asList(
                        new QuizModels.Answer("造型好酷！我要嘗一口！", Mood.HAPPY),
                        new QuizModels.Answer("做得這麼精緻，捨不得吃。", Mood.SAD),
                        new QuizModels.Answer("為什麼不做成正常樣子？", Mood.ANGER),
                        new QuizModels.Answer("怕點心味道很奇怪。", Mood.FEAR),
                        new QuizModels.Answer("連吃東西我都這麼膽小。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心點心會不會過期？", Mood.ANXIETY),
                        new QuizModels.Answer("顏色太鮮豔，感覺有好多色素。", Mood.DISGUST)
                )),
                new QuizModels.Question("大象用鼻子噴水玩，你的感覺是？", Arrays.asList(
                        new QuizModels.Answer("哈哈，好像淋浴一樣好玩！", Mood.HAPPY),
                        new QuizModels.Answer("水噴到眼睛，有點想哭。", Mood.SAD),
                        new QuizModels.Answer("我衣服都濕了，真生氣！", Mood.ANGER),
                        new QuizModels.Answer("怕被強力水柱沖倒。", Mood.FEAR),
                        new QuizModels.Answer("我潑水都沒牠這麼厲害。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心鼻子裡的水不乾淨。", Mood.ANXIETY),
                        new QuizModels.Answer("鼻涕和水混在一起，真噁心。", Mood.DISGUST)
                )),
                new QuizModels.Question("派對結束時，動物們擁抱你，你會？", Arrays.asList(
                        new QuizModels.Answer("開心擁抱，約定下次再見！", Mood.HAPPY),
                        new QuizModels.Answer("擁抱時感到離別的難過。", Mood.SAD),
                        new QuizModels.Answer("別抱這麼緊，我不喜歡！", Mood.ANGER),
                        new QuizModels.Answer("怕牠們的爪子會抓傷我。", Mood.FEAR),
                        new QuizModels.Answer("我值得牠們這麼喜歡嗎？", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心自己身上有汗味。", Mood.ANXIETY),
                        new QuizModels.Answer("牠們毛好多，感覺會過敏。", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme6() {
        String title = "時光機器之旅";
        String story = "你坐進時光機器，穿越到恐龍時代和未來城市，見證不可思議的奇蹟！";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("當你看到真實恐龍時，你的反應是？", Arrays.asList(
                        new QuizModels.Answer("太壯觀了！夢想成真！", Mood.HAPPY),
                        new QuizModels.Answer("牠們後來滅絕了，好可憐。", Mood.SAD),
                        new QuizModels.Answer("牠們叫聲好大，真吵！", Mood.ANGER),
                        new QuizModels.Answer("怕被恐龍當成食物。", Mood.FEAR),
                        new QuizModels.Answer("在牠們面前，我太渺小了。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心機器失靈，回不去了。", Mood.ANXIETY),
                        new QuizModels.Answer("周圍的氣味好難聞。", Mood.DISGUST)
                )),
                new QuizModels.Question("未來機器人送你高科技玩具，你會？", Arrays.asList(
                        new QuizModels.Answer("太好了！這玩具好先進！", Mood.HAPPY),
                        new QuizModels.Answer("未來的小孩真幸福，我有點嫉妒。", Mood.SAD),
                        new QuizModels.Answer("為什麼不送更實用的東西？", Mood.ANGER),
                        new QuizModels.Answer("怕玩具會有雷射傷害我。", Mood.FEAR),
                        new QuizModels.Answer("我連說明書都看不懂。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心弄壞這麼貴重的禮物。", Mood.ANXIETY),
                        new QuizModels.Answer("金屬玩具冷冰冰的，不喜歡。", Mood.DISGUST)
                )),
                new QuizModels.Question("時光機器晃動一下，你會？", Arrays.asList(
                        new QuizModels.Answer("好像坐雲霄飛車，真刺激！", Mood.HAPPY),
                        new QuizModels.Answer("如果時光旅行是夢，我會失望。", Mood.SAD),
                        new QuizModels.Answer("誰發明的爛機器！", Mood.ANGER),
                        new QuizModels.Answer("怕機器故障，卡在時空裡。", Mood.FEAR),
                        new QuizModels.Answer("都是我亂按鈕的錯。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("緊張地檢查所有儀表。", Mood.ANXIETY),
                        new QuizModels.Answer("晃動讓我頭暈想吐。", Mood.DISGUST)
                )),
                new QuizModels.Question("你遇到古代公主，她問你的世界，你會？", Arrays.asList(
                        new QuizModels.Answer("興奮地分享所有新奇事物！", Mood.HAPPY),
                        new QuizModels.Answer("她永遠看不到這些，真可惜。", Mood.SAD),
                        new QuizModels.Answer("她問題好多，有點煩。", Mood.ANGER),
                        new QuizModels.Answer("怕說錯話改變歷史。", Mood.FEAR),
                        new QuizModels.Answer("我的故事太平凡了。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心她聽不懂我的話。", Mood.ANXIETY),
                        new QuizModels.Answer("不想跟她解釋這麼多。", Mood.DISGUST)
                )),
                new QuizModels.Question("未來城市車子會飛，你的感覺是？", Arrays.asList(
                        new QuizModels.Answer("好方便！我也想試著開！", Mood.HAPPY),
                        new QuizModels.Answer("對比現在，交通真糟糕。", Mood.SAD),
                        new QuizModels.Answer("滿天都是車，好亂！", Mood.ANGER),
                        new QuizModels.Answer("怕車子會從天上掉下來。", Mood.FEAR),
                        new QuizModels.Answer("我學不會操作這種車。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心空中交通規則太複雜。", Mood.ANXIETY),
                        new QuizModels.Answer("排放的廢氣味道真怪。", Mood.DISGUST)
                )),
                new QuizModels.Question("回家後，你對這次旅行怎麼想？", Arrays.asList(
                        new QuizModels.Answer("真是最棒的冒險！", Mood.HAPPY),
                        new QuizModels.Answer("回到平凡生活，有點失落。", Mood.SAD),
                        new QuizModels.Answer("氣自己沒多看幾個時代。", Mood.ANGER),
                        new QuizModels.Answer("怕時空旅行會有後遺症。", Mood.FEAR),
                        new QuizModels.Answer("我不配擁有這樣的經歷。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心自己是否回到了正確的時間線。", Mood.ANXIETY),
                        new QuizModels.Answer("旅行讓我好累，真不舒服。", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme7() {
        String title = "秘密花園挑戰";
        String story = "你發現一個隱藏花園，裡面有會說話的花和迷宮，每關都有小驚喜等你！";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("當玫瑰花教你種花魔法時，你會？", Arrays.asList(
                        new QuizModels.Answer("太神奇了！我要馬上試！", Mood.HAPPY),
                        new QuizModels.Answer("魔法再厲害，花還是會凋謝。", Mood.SAD),
                        new QuizModels.Answer("為什麼咒語這麼難念！", Mood.ANGER),
                        new QuizModels.Answer("怕魔法會引來不好的東西。", Mood.FEAR),
                        new QuizModels.Answer("我沒有魔法天分，學不會的。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心念錯咒語會出事。", Mood.ANXIETY),
                        new QuizModels.Answer("魔法會弄髒我的手嗎？", Mood.DISGUST)
                )),
                new QuizModels.Question("你走進迷宮，路徑分兩條，你會？", Arrays.asList(
                        new QuizModels.Answer("探險開始了！隨便選一條！", Mood.HAPPY),
                        new QuizModels.Answer("無論選哪條，都會錯過另一邊的風景。", Mood.SAD),
                        new QuizModels.Answer("誰設計這麼複雜的迷宮！", Mood.ANGER),
                        new QuizModels.Answer("怕在裡面迷路一整天。", Mood.FEAR),
                        new QuizModels.Answer("我方向感很差，一定會走錯。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("猶豫不決，怕選錯路。", Mood.ANXIETY),
                        new QuizModels.Answer("迷宮牆上都是青苔，真髒。", Mood.DISGUST)
                )),
                new QuizModels.Question("蝴蝶送你翅膀試飛，你會？", Arrays.asList(
                        new QuizModels.Answer("太棒了！我可以飛了！", Mood.HAPPY),
                        new QuizModels.Answer("飛得再高，還是要落地。", Mood.SAD),
                        new QuizModels.Answer("翅膀為什麼這麼脆弱！", Mood.ANGER),
                        new QuizModels.Answer("怕飛太高會摔下來。", Mood.FEAR),
                        new QuizModels.Answer("我這麼重，翅膀撐不住我。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心不會控制飛行方向。", Mood.ANXIETY),
                        new QuizModels.Answer("翅膀上有鱗粉，好噁心。", Mood.DISGUST)
                )),
                new QuizModels.Question("花園精靈出謎題，答對有獎，你會？", Arrays.asList(
                        new QuizModels.Answer("真有趣！我來動動腦！", Mood.HAPPY),
                        new QuizModels.Answer("答對了，獎品也會用完。", Mood.SAD),
                        new QuizModels.Answer("為什麼要猜謎這麼麻煩？", Mood.ANGER),
                        new QuizModels.Answer("怕答錯會被精靈嘲笑。", Mood.FEAR),
                        new QuizModels.Answer("我這麼笨，一定猜不中。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心時間不夠想答案。", Mood.ANXIETY),
                        new QuizModels.Answer("不想玩這種腦力遊戲。", Mood.DISGUST)
                )),
                new QuizModels.Question("天氣突然下雨，花朵撐葉子傘，你會？", Arrays.asList(
                        new QuizModels.Answer("在雨中跳舞真好玩！", Mood.HAPPY),
                        new QuizModels.Answer("下雨天，心情也憂鬱起來。", Mood.SAD),
                        new QuizModels.Answer("氣天氣破壞了我的探險！", Mood.ANGER),
                        new QuizModels.Answer("怕會打雷或淋濕生病。", Mood.FEAR),
                        new QuizModels.Answer("我連天氣都預測不了。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心葉子傘會不會漏雨。", Mood.ANXIETY),
                        new QuizModels.Answer("雨水弄髒了我的鞋子。", Mood.DISGUST)
                )),
                new QuizModels.Question("挑戰成功，花園送你種子，你會？", Arrays.asList(
                        new QuizModels.Answer("謝謝！我會讓它開出最美的花！", Mood.HAPPY),
                        new QuizModels.Answer("種子能發芽，但我可能照顧不好。", Mood.SAD),
                        new QuizModels.Answer("為什麼不送現成的花？", Mood.ANGER),
                        new QuizModels.Answer("怕種子會長出怪植物。", Mood.FEAR),
                        new QuizModels.Answer("我連仙人掌都養不活。", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("擔心種植方法太困難。", Mood.ANXIETY),
                        new QuizModels.Answer("種子看起來像蟲卵，不舒服。", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }
}