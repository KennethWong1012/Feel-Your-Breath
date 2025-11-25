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
        String title = "The Magical Forest Adventure";
        String story = "You walk into a shimmering magical forest where the trees can talk, and the animals invite you to explore hidden treasures!";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("A talking tree gives you a glowing leaf. What do you think?", Arrays.asList(
                        new QuizModels.Answer("Awesome! I'm going to treasure this.", Mood.HAPPY),
                        new QuizModels.Answer("I wish my friends could see this too.", Mood.SAD),
                        new QuizModels.Answer("Why only one leaf? How stingy.", Mood.ANGER),
                        new QuizModels.Answer("I wonder if this leaf has a magical curse.", Mood.FEAR),
                        new QuizModels.Answer("I don't deserve such a nice gift.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("How should I reciprocate?", Mood.ANXIETY),
                        new QuizModels.Answer("This leaf is sticky; I don't like it.", Mood.DISGUST)
                )),
                new QuizModels.Question("A little deer asks you to help it find its way home. You...", Arrays.asList(
                        new QuizModels.Answer("Happily agree, feeling great about being able to help.", Mood.HAPPY),
                        new QuizModels.Answer("Feel a bit sad thinking about the deer being lost.", Mood.SAD),
                        new QuizModels.Answer("Feel like it's interrupting your exploration.", Mood.ANGER),
                        new QuizModels.Answer("Worry that you might get lost yourself.", Mood.FEAR),
                        new QuizModels.Answer("Are afraid you don't have the ability to help it.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Nervously think, \"What if I can't find the way?\"", Mood.ANXIETY),
                        new QuizModels.Answer("Don't want to touch an unfamiliar animal.", Mood.DISGUST)
                )),
                new QuizModels.Question("A strange sound comes from deep in the forest. Your reaction is to...", Arrays.asList(
                        new QuizModels.Answer("Feel curious and excited, wanting to check it out.", Mood.HAPPY),
                        new QuizModels.Answer("Feel like the sound seems lonely.", Mood.SAD),
                        new QuizModels.Answer("Feel annoyed by the scary sound.", Mood.ANGER),
                        new QuizModels.Answer("Stop immediately, not daring to go further.", Mood.FEAR),
                        new QuizModels.Answer("Think, \"It must be a monster I can't defeat.\"", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Feel your heart race, not knowing what to do.", Mood.ANXIETY),
                        new QuizModels.Answer("Really dislike this eerie sound.", Mood.DISGUST)
                )),
                new QuizModels.Question("You find an opportunity to swing across a riverbank on a vine. You...", Arrays.asList(
                        new QuizModels.Answer("Think it's thrilling and try it immediately!", Mood.HAPPY),
                        new QuizModels.Answer("Feel like crying while swinging across.", Mood.SAD),
                        new QuizModels.Answer("Get angry at yourself for not knowing how to fly.", Mood.ANGER),
                        new QuizModels.Answer("Hold onto the vine tightly, not daring to move.", Mood.FEAR),
                        new QuizModels.Answer("Think others would definitely do this better than me.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Repeatedly wonder if the vine will break.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the vine looks too dirty and don't want to touch it.", Mood.DISGUST)
                )),
                new QuizModels.Question("The animals throw a welcome party for you. You feel...", Arrays.asList(
                        new QuizModels.Answer("Very happy and dance with everyone.", Mood.HAPPY),
                        new QuizModels.Answer("A bit sad that the party will eventually end.", Mood.SAD),
                        new QuizModels.Answer("Annoyed by the games they planned.", Mood.ANGER),
                        new QuizModels.Answer("Nervous being watched by so many animals.", Mood.FEAR),
                        new QuizModels.Answer("That you aren't worth all this fuss.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worried about making a mistake at the party.", Mood.ANXIETY),
                        new QuizModels.Answer("That you don't like the party food.", Mood.DISGUST)
                )),
                new QuizModels.Question("The adventure is over, and you must leave the magical forest. You...", Arrays.asList(
                        new QuizModels.Answer("Look forward to coming back to play next time.", Mood.HAPPY),
                        new QuizModels.Answer("Are reluctant to leave and feel like crying.", Mood.SAD),
                        new QuizModels.Answer("Get angry about why you can't stay.", Mood.ANGER),
                        new QuizModels.Answer("Are afraid you'll forget this place after leaving.", Mood.FEAR),
                        new QuizModels.Answer("Think the forest will be just as happy without me.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry that you might not be able to come back in the future.", Mood.ANXIETY),
                        new QuizModels.Answer("Are relieved to finally leave this troublesome place.", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme2() {
        String title = "Spaceship Expedition";
        String story = "You pilot a spaceship to an unknown planet, where friendly aliens and twinkling stars await you!";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("The spaceship is about to land on a planet no human has ever visited. You feel...", Arrays.asList(
                        new QuizModels.Answer("Incredibly excited, ready to be the first one out!", Mood.HAPPY),
                        new QuizModels.Answer("A bit melancholic, thinking about being alone.", Mood.SAD),
                        new QuizModels.Answer("Impatient with the console's slow speed.", Mood.ANGER),
                        new QuizModels.Answer("Afraid of unknown dangers behind the door.", Mood.FEAR),
                        new QuizModels.Answer("That I'm probably the least suitable person for this mission.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worried that the ship's air system might malfunction.", Mood.ANXIETY),
                        new QuizModels.Answer("That the alien world is probably full of germs.", Mood.DISGUST)
                )),
                new QuizModels.Question("An alien with a strange appearance reaches out its hand to you. You...", Arrays.asList(
                        new QuizModels.Answer("Happily shake its hand and make a new friend.", Mood.HAPPY),
                        new QuizModels.Answer("Feel sad because its hand looks lonely.", Mood.SAD),
                        new QuizModels.Answer("Dislike it approaching without permission.", Mood.ANGER),
                        new QuizModels.Answer("Are afraid it might hurt you and take a step back.", Mood.FEAR),
                        new QuizModels.Answer("Think, \"My hand is different from its, how awful.\"", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Hesitate about whether you should reach out.", Mood.ANXIETY),
                        new QuizModels.Answer("Think it looks slimy and don't want to touch it.", Mood.DISGUST)
                )),
                new QuizModels.Question("The alien food looks like a glowing blob of jelly. You...", Arrays.asList(
                        new QuizModels.Answer("Think it's so cool! I want to try it!", Mood.HAPPY),
                        new QuizModels.Answer("Start missing food from Earth.", Mood.SAD),
                        new QuizModels.Answer("Wonder why there's no normal food?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid your body will have an allergic reaction.", Mood.FEAR),
                        new QuizModels.Answer("Think, \"Even with eating, I'm so cowardly.\"", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry that it will give you a stomachache.", Mood.ANXIETY),
                        new QuizModels.Answer("Think it looks disgusting and don't want to try it.", Mood.DISGUST)
                )),
                new QuizModels.Question("You realize you've forgotten the way back to Earth. Your thought is...", Arrays.asList(
                        new QuizModels.Answer("Great! I can keep exploring!", Mood.HAPPY),
                        new QuizModels.Answer("I might never see my family again.", Mood.SAD),
                        new QuizModels.Answer("Get angry at yourself for being so careless.", Mood.ANGER),
                        new QuizModels.Answer("It's over; I'll be drifting in space.", Mood.FEAR),
                        new QuizModels.Answer("I always mess up important things.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Keep thinking about various terrible consequences.", Mood.ANXIETY),
                        new QuizModels.Answer("Hate this feeling of losing control.", Mood.DISGUST)
                )),
                new QuizModels.Question("Your alien friends want to learn an Earth game. You...", Arrays.asList(
                        new QuizModels.Answer("Happily teach them how to play hide-and-seek.", Mood.HAPPY),
                        new QuizModels.Answer("Feel a bit homesick while playing.", Mood.SAD),
                        new QuizModels.Answer("Get angry because they can't seem to learn it.", Mood.ANGER),
                        new QuizModels.Answer("Are afraid they won't like Earth games.", Mood.FEAR),
                        new QuizModels.Answer("Think my explanation isn't clear at all.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry that the game rules are too complicated.", Mood.ANXIETY),
                        new QuizModels.Answer("Don't want to share things about Earth with them.", Mood.DISGUST)
                )),
                new QuizModels.Question("The mission is over, and you are welcomed as a hero. You feel...", Arrays.asList(
                        new QuizModels.Answer("This is such an honor!", Mood.HAPPY),
                        new QuizModels.Answer("Empty after all the excitement dies down.", Mood.SAD),
                        new QuizModels.Answer("That they don't understand what really happened.", Mood.ANGER),
                        new QuizModels.Answer("Afraid that people's expectations of you are now too high.", Mood.FEAR),
                        new QuizModels.Answer("That I'm not a real hero.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worried that you can't perform this well next time.", Mood.ANXIETY),
                        new QuizModels.Answer("Tired of these hypocritical welcomes.", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme3() {
        String title = "Journey to the Underwater Kingdom";
        String story = "You turn into a little fish and swim into a mysterious underwater kingdom, where there are talking corals and shining pearls!";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("When a dolphin challenges you to a race, you...", Arrays.asList(
                        new QuizModels.Answer("Think it's so fun! I can definitely win!", Mood.HAPPY),
                        new QuizModels.Answer("Wonder if it asked me because it's lonely?", Mood.SAD),
                        new QuizModels.Answer("Wonder why it acts like it's faster than me?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of swimming too fast and hitting something.", Mood.FEAR),
                        new QuizModels.Answer("Think I swim too awkwardly and don't dare to race.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry about getting a cramp mid-race.", Mood.ANXIETY),
                        new QuizModels.Answer("Don't want to race in the murky water.", Mood.DISGUST)
                )),
                new QuizModels.Question("You see glowing jellyfish dancing. Your reaction is to...", Arrays.asList(
                        new QuizModels.Answer("Surprisingly join their dance party!", Mood.HAPPY),
                        new QuizModels.Answer("Feel their light makes me feel lonely.", Mood.SAD),
                        new QuizModels.Answer("Think the light is too glaring, it's uncomfortable.", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of being stung.", Mood.FEAR),
                        new QuizModels.Answer("Think my dance moves must look terrible.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry if getting too close is dangerous.", Mood.ANXIETY),
                        new QuizModels.Answer("Think they look slimy and disgusting.", Mood.DISGUST)
                )),
                new QuizModels.Question("An octopus gives you a bubble gift. You...", Arrays.asList(
                        new QuizModels.Answer("Happily accept it, thinking it's so special!", Mood.HAPPY),
                        new QuizModels.Answer("Think bubbles will always pop, just like beautiful dreams.", Mood.SAD),
                        new QuizModels.Answer("Wonder why it gave me something so fragile?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid there might be something strange inside the bubble.", Mood.FEAR),
                        new QuizModels.Answer("Think I don't deserve gifts.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry that popping it will upset the octopus.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the bubble smells fishy; I don't like it.", Mood.DISGUST)
                )),
                new QuizModels.Question("The gate to the underwater castle is closed. You...", Arrays.asList(
                        new QuizModels.Answer("Excitedly knock, wondering who will open it!", Mood.HAPPY),
                        new QuizModels.Answer("Feel rejected with the gate closed.", Mood.SAD),
                        new QuizModels.Answer("Think, \"Who closed the gate? How awful!\"", Mood.ANGER),
                        new QuizModels.Answer("Are afraid there are scary guards behind the door.", Mood.FEAR),
                        new QuizModels.Answer("Think a small fish like me doesn't deserve to enter.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Hesitate about whether to ring the doorbell.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the gate is covered in algae; it's so dirty.", Mood.DISGUST)
                )),
                new QuizModels.Question("A whale sings a lullaby. You feel...", Arrays.asList(
                        new QuizModels.Answer("It sounds so beautiful! I feel so happy!", Mood.HAPPY),
                        new QuizModels.Answer("The song makes me miss my mom.", Mood.SAD),
                        new QuizModels.Answer("The sound is too loud! So noisy!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the huge sound might injure me.", Mood.FEAR),
                        new QuizModels.Answer("I could never sing that well.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry if the whale is calling for help?", Mood.ANXIETY),
                        new QuizModels.Answer("Dislike this low, vibrating resonance.", Mood.DISGUST)
                )),
                new QuizModels.Question("The journey ends, and you turn back into a human. You think...", Arrays.asList(
                        new QuizModels.Answer("The underwater world was truly amazing!", Mood.HAPPY),
                        new QuizModels.Answer("Are reluctant to leave your fish friends.", Mood.SAD),
                        new QuizModels.Answer("Are angry you didn't collect more pearls.", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the experience was just a dream.", Mood.FEAR),
                        new QuizModels.Answer("That I'm more used to being a human.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry about the ocean being polluted.", Mood.ANXIETY),
                        new QuizModels.Answer("That the feeling of being wet and sticky is really uncomfortable.", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme4() {
        String title = "Cloud Castle Adventure";
        String story = "You fly to a castle in the clouds on a balloon! There are cotton candy clouds and a laughing sun; everything is soft and floaty!";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("When a cloud turns into a soft bed, you...", Arrays.asList(
                        new QuizModels.Answer("Happily bounce on it!", Mood.HAPPY),
                        new QuizModels.Answer("Feel sad that you can only enjoy such comfort briefly.", Mood.SAD),
                        new QuizModels.Answer("Wonder why the cloud bed is so unstable?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid you might fall through a gap in the clouds.", Mood.FEAR),
                        new QuizModels.Answer("Think I shouldn't dirty such a white cloud.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry about collapsing the cloud bed.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the cloud is damp; I don't like it.", Mood.DISGUST)
                )),
                new QuizModels.Question("The sun blinks at you. Your reaction is to...", Arrays.asList(
                        new QuizModels.Answer("Surprised, blink back at it!", Mood.HAPPY),
                        new QuizModels.Answer("It must be lonely up there all by itself.", Mood.SAD),
                        new QuizModels.Answer("The light is too strong! My eyes hurt!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of getting burned by its heat.", Mood.FEAR),
                        new QuizModels.Answer("Why is it looking at someone as ordinary as me?", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Is it blinking because something bad is going to happen?", Mood.ANXIETY),
                        new QuizModels.Answer("Dislike this feeling of being watched.", Mood.DISGUST)
                )),
                new QuizModels.Question("You find a rainbow slide. You...", Arrays.asList(
                        new QuizModels.Answer("Think it's so exciting! I'll slide down again and again!", Mood.HAPPY),
                        new QuizModels.Answer("Feel it's a pity such a beautiful rainbow will disappear.", Mood.SAD),
                        new QuizModels.Answer("Wonder why the slide is so steep?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid you'll slide right off into outer space.", Mood.FEAR),
                        new QuizModels.Answer("Think I'm too heavy; will I crush the rainbow?", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Hesitate to slide, fearing danger.", Mood.ANXIETY),
                        new QuizModels.Answer("Don't want to get your clothes wet.", Mood.DISGUST)
                )),
                new QuizModels.Question("The wind carries you high up. You feel...", Arrays.asList(
                        new QuizModels.Answer("The feeling of flying is so freeing!", Mood.HAPPY),
                        new QuizModels.Answer("No matter how high you fly, you still have to come down eventually.", Mood.SAD),
                        new QuizModels.Answer("The wind is too strong; it's messing up my hair!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the wind might suddenly stop.", Mood.FEAR),
                        new QuizModels.Answer("I can't control the flying direction well.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry about hitting a bird or a plane.", Mood.ANXIETY),
                        new QuizModels.Answer("There's sand in the wind; I hate it.", Mood.DISGUST)
                )),
                new QuizModels.Question("There is a riddle in front of the castle gate. You...", Arrays.asList(
                        new QuizModels.Answer("Think it's fun! I like using my brain!", Mood.HAPPY),
                        new QuizModels.Answer("Think, \"If I get it wrong, will I be locked out forever?\"", Mood.SAD),
                        new QuizModels.Answer("Think, \"Who came up with such a hard question!\"", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of being punished for a wrong answer.", Mood.FEAR),
                        new QuizModels.Answer("Think I'm too stupid to figure it out.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry, \"What if I only have one chance?\"", Mood.ANXIETY),
                        new QuizModels.Answer("Find riddle games boring.", Mood.DISGUST)
                )),
                new QuizModels.Question("As you leave, the clouds give you a gift. You...", Arrays.asList(
                        new QuizModels.Answer("Say, \"Thank you! I will treasure it!\"", Mood.HAPPY),
                        new QuizModels.Answer("Feel sad to receive a gift but have to say goodbye.", Mood.SAD),
                        new QuizModels.Answer("Wonder why they didn't give something better?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the gift will disappear on the way home.", Mood.FEAR),
                        new QuizModels.Answer("Think I don't deserve such a nice gift.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry if the gift comes with a price?", Mood.ANXIETY),
                        new QuizModels.Answer("Think the cloud's gift is just water vapor.", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme5() {
        String title = "Animal Carnival";
        String story = "You are invited to an animal carnival! The lion can dance, the monkey can do magic, and everyone is having a party together!";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("When the lion invites you to dance, you...", Arrays.asList(
                        new QuizModels.Answer("Feel so honored! Start dancing with it immediately!", Mood.HAPPY),
                        new QuizModels.Answer("Think its dance moves look a bit sad.", Mood.SAD),
                        new QuizModels.Answer("Think its roar is too loud! It's uncomfortable!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid it might accidentally step on you.", Mood.FEAR),
                        new QuizModels.Answer("Think I don't dance well and will embarrass it.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Nervously think about the dance steps.", Mood.ANXIETY),
                        new QuizModels.Answer("Dislike its smell.", Mood.DISGUST)
                )),
                new QuizModels.Question("The monkey conjures colorful balloons. Your reaction is to...", Arrays.asList(
                        new QuizModels.Answer("Be surprised and clap cheerfully!", Mood.HAPPY),
                        new QuizModels.Answer("Think the monkey would be sad if the balloons popped.", Mood.SAD),
                        new QuizModels.Answer("Think, \"They're just balloons, no big deal.\"", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the balloons will suddenly pop.", Mood.FEAR),
                        new QuizModels.Answer("Think I can't even conjure one balloon.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry the balloons will be popped by tree branches.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the rubber smell of the balloons is awful.", Mood.DISGUST)
                )),
                new QuizModels.Question("You are chosen to be the party leader. You...", Arrays.asList(
                        new QuizModels.Answer("Think, \"Great! I'll lead everyone in games!\"", Mood.HAPPY),
                        new QuizModels.Answer("Feel that being the leader means taking on responsibility.", Mood.SAD),
                        new QuizModels.Answer("Wonder, \"Why do I have to do so much?\"", Mood.ANGER),
                        new QuizModels.Answer("Are afraid no one will listen to you.", Mood.FEAR),
                        new QuizModels.Answer("Think I have no leadership skills.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry about messing up the party.", Mood.ANXIETY),
                        new QuizModels.Answer("Think it's troublesome; I don't want to manage others.", Mood.DISGUST)
                )),
                new QuizModels.Question("The food table has snacks with weird shapes. You...", Arrays.asList(
                        new QuizModels.Answer("Think the shapes are so cool! I'll take a bite!", Mood.HAPPY),
                        new QuizModels.Answer("Feel they are made so exquisitely, it's a shame to eat them.", Mood.SAD),
                        new QuizModels.Answer("Wonder why they aren't made in normal shapes?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the snacks will taste strange.", Mood.FEAR),
                        new QuizModels.Answer("Think, \"Even with eating, I'm so cowardly.\"", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry if the snacks might be expired?", Mood.ANXIETY),
                        new QuizModels.Answer("Think the colors are too bright; they must have a lot of artificial coloring.", Mood.DISGUST)
                )),
                new QuizModels.Question("The elephant plays by spraying water with its trunk. You feel...", Arrays.asList(
                        new QuizModels.Answer("Haha, it's as fun as a shower!", Mood.HAPPY),
                        new QuizModels.Answer("Feel like crying when the water gets in your eyes.", Mood.SAD),
                        new QuizModels.Answer("Get angry because your clothes are all wet!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of being knocked over by the powerful water jet.", Mood.FEAR),
                        new QuizModels.Answer("Think I'm not as good at splashing water as it is.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry if the water in its trunk is clean.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the mix of snot and water is disgusting.", Mood.DISGUST)
                )),
                new QuizModels.Question("When the party ends, the animals hug you. You...", Arrays.asList(
                        new QuizModels.Answer("Happily hug them back, promising to meet again!", Mood.HAPPY),
                        new QuizModels.Answer("Feel the sadness of parting during the hug.", Mood.SAD),
                        new QuizModels.Answer("Think, \"Don't hug so tight, I don't like it!\"", Mood.ANGER),
                        new QuizModels.Answer("Are afraid their claws might scratch you.", Mood.FEAR),
                        new QuizModels.Answer("Wonder, \"Do I deserve their affection?\"", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry you might have body odor.", Mood.ANXIETY),
                        new QuizModels.Answer("Think they have too much fur; it feels like it will cause allergies.", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme6() {
        String title = "Time Machine Journey";
        String story = "You get into a time machine, traveling to the age of dinosaurs and future cities, witnessing incredible miracles!";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("When you see a real dinosaur, your reaction is...", Arrays.asList(
                        new QuizModels.Answer("So magnificent! A dream come true!", Mood.HAPPY),
                        new QuizModels.Answer("They went extinct later; how sad.", Mood.SAD),
                        new QuizModels.Answer("Their calls are so loud! So noisy!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of being eaten.", Mood.FEAR),
                        new QuizModels.Answer("Feel so insignificant in front of them.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry the machine will malfunction, and you can't return.", Mood.ANXIETY),
                        new QuizModels.Answer("The smell here is awful.", Mood.DISGUST)
                )),
                new QuizModels.Question("A future robot gives you a high-tech toy. You...", Arrays.asList(
                        new QuizModels.Answer("Think, \"Great! This toy is so advanced!\"", Mood.HAPPY),
                        new QuizModels.Answer("Feel a bit jealous that future children are so fortunate.", Mood.SAD),
                        new QuizModels.Answer("Wonder why it didn't give something more practical?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the toy might have lasers that hurt you.", Mood.FEAR),
                        new QuizModels.Answer("Think I can't even understand the manual.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry about breaking such an expensive gift.", Mood.ANXIETY),
                        new QuizModels.Answer("Think metal toys are cold and unfeeling; I don't like them.", Mood.DISGUST)
                )),
                new QuizModels.Question("The time machine shakes suddenly. You...", Arrays.asList(
                        new QuizModels.Answer("Think it's like a roller coaster, so thrilling!", Mood.HAPPY),
                        new QuizModels.Answer("Would be disappointed if time travel was just a dream.", Mood.SAD),
                        new QuizModels.Answer("Think, \"Who invented this piece of junk!\"", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the machine will break down, trapping you in time.", Mood.FEAR),
                        new QuizModels.Answer("Think it's my fault for pressing buttons randomly.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Nervously check all the gauges.", Mood.ANXIETY),
                        new QuizModels.Answer("Feel the shaking makes you dizzy and nauseous.", Mood.DISGUST)
                )),
                new QuizModels.Question("You meet an ancient princess who asks about your world. You...", Arrays.asList(
                        new QuizModels.Answer("Excitedly share all the novelties!", Mood.HAPPY),
                        new QuizModels.Answer("Feel it's a pity she will never see these things.", Mood.SAD),
                        new QuizModels.Answer("Find her questions too numerous and annoying.", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of saying the wrong thing and changing history.", Mood.FEAR),
                        new QuizModels.Answer("Think my stories are too mundane.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry she won't understand what you're saying.", Mood.ANXIETY),
                        new QuizModels.Answer("Don't want to explain so much to her.", Mood.DISGUST)
                )),
                new QuizModels.Question("In the future city, the cars can fly. You feel...", Arrays.asList(
                        new QuizModels.Answer("So convenient! I want to try driving one!", Mood.HAPPY),
                        new QuizModels.Answer("Compared to now, the traffic is really terrible.", Mood.SAD),
                        new QuizModels.Answer("The sky is full of cars; what a mess!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the cars might fall from the sky.", Mood.FEAR),
                        new QuizModels.Answer("Think I could never learn to operate this kind of car.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry the aerial traffic rules are too complicated.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the exhaust fumes smell really weird.", Mood.DISGUST)
                )),
                new QuizModels.Question("After returning home, what do you think about this trip?", Arrays.asList(
                        new QuizModels.Answer("It was the best adventure!", Mood.HAPPY),
                        new QuizModels.Answer("Feel a bit失落 returning to ordinary life.", Mood.SAD), // Note: Chinese character in source, assuming it means 'lost' or 'dejected'
                        new QuizModels.Answer("Are angry you didn't visit more eras.", Mood.ANGER),
                        new QuizModels.Answer("Are afraid time travel might have side effects.", Mood.FEAR),
                        new QuizModels.Answer("Think I don't deserve such an experience.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry if you returned to the correct timeline.", Mood.ANXIETY),
                        new QuizModels.Answer("Feel the trip was exhausting and uncomfortable.", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }

    private static StoryTheme createTheme7() {
        String title = "Secret Garden Challenge";
        String story = "You discover a hidden garden with talking flowers and a maze; each challenge holds a little surprise waiting for you!";
        List<QuizModels.Question> questions = Arrays.asList(
                new QuizModels.Question("When a rose teaches you flower-growing magic, you...", Arrays.asList(
                        new QuizModels.Answer("Think it's amazing! I'll try it right away!", Mood.HAPPY),
                        new QuizModels.Answer("Think even with magic, flowers will still wither.", Mood.SAD),
                        new QuizModels.Answer("Wonder why the spell is so hard to chant!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the magic might attract something bad.", Mood.FEAR),
                        new QuizModels.Answer("Think I have no talent for magic; I won't learn it.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry that mischanting the spell will cause trouble.", Mood.ANXIETY),
                        new QuizModels.Answer("Wonder if the magic will dirty my hands?", Mood.DISGUST)
                )),
                new QuizModels.Question("You enter the maze, and the path splits in two. You...", Arrays.asList(
                        new QuizModels.Answer("Think, \"The adventure begins! I'll pick one randomly!\"", Mood.HAPPY),
                        new QuizModels.Answer("Feel that no matter which path you choose, you'll miss the scenery on the other.", Mood.SAD),
                        new QuizModels.Answer("Think, \"Who designed such a complicated maze!\"", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of being lost inside all day.", Mood.FEAR),
                        new QuizModels.Answer("Think my sense of direction is poor; I'll definitely choose wrong.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Hesitate, afraid of choosing the wrong path.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the maze walls are covered in moss; so dirty.", Mood.DISGUST)
                )),
                new QuizModels.Question("A butterfly offers you its wings to try flying. You...", Arrays.asList(
                        new QuizModels.Answer("Think, \"Awesome! I can fly!\"", Mood.HAPPY),
                        new QuizModels.Answer("Think no matter how high you fly, you still have to land.", Mood.SAD),
                        new QuizModels.Answer("Wonder why the wings are so fragile!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of flying too high and falling.", Mood.FEAR),
                        new QuizModels.Answer("Think I'm too heavy; the wings can't support me.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry about not being able to control the flight direction.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the wings have scales; so gross.", Mood.DISGUST)
                )),
                new QuizModels.Question("A garden fairy gives you a riddle; a prize for the correct answer. You...", Arrays.asList(
                        new QuizModels.Answer("Think it's fun! I'll use my brain!", Mood.HAPPY),
                        new QuizModels.Answer("Think even if you get it right, the prize will eventually be used up.", Mood.SAD),
                        new QuizModels.Answer("Wonder why guessing riddles is so troublesome?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of being laughed at by the fairy for a wrong answer.", Mood.FEAR),
                        new QuizModels.Answer("Think I'm too stupid to guess correctly.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry there isn't enough time to think of an answer.", Mood.ANXIETY),
                        new QuizModels.Answer("Don't want to play this kind of brain game.", Mood.DISGUST)
                )),
                new QuizModels.Question("It suddenly starts raining, and the flowers hold leaf-umbrellas for you. You...", Arrays.asList(
                        new QuizModels.Answer("Think dancing in the rain is so fun!", Mood.HAPPY),
                        new QuizModels.Answer("Feel your mood becomes gloomy on rainy days.", Mood.SAD),
                        new QuizModels.Answer("Get angry that the weather ruined your exploration!", Mood.ANGER),
                        new QuizModels.Answer("Are afraid of thunder or getting sick from the rain.", Mood.FEAR),
                        new QuizModels.Answer("Think I can't even predict the weather.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry if the leaf-umbrella will leak.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the rain has dirtied my shoes.", Mood.DISGUST)
                )),
                new QuizModels.Question("After succeeding in the challenge, the garden gives you seeds. You...", Arrays.asList(
                        new QuizModels.Answer("Say, \"Thank you! I'll make it bloom into the most beautiful flower!\"", Mood.HAPPY),
                        new QuizModels.Answer("Think the seed can sprout, but I might not take good care of it.", Mood.SAD),
                        new QuizModels.Answer("Wonder why it didn't give a ready-made flower?", Mood.ANGER),
                        new QuizModels.Answer("Are afraid the seed might grow into a strange plant.", Mood.FEAR),
                        new QuizModels.Answer("Think I can't even keep a cactus alive.", Mood.SELF_ABASEMENT),
                        new QuizModels.Answer("Worry the planting method is too difficult.", Mood.ANXIETY),
                        new QuizModels.Answer("Think the seeds look like insect eggs; it's uncomfortable.", Mood.DISGUST)
                ))
        );
        return new StoryTheme(title, story, questions);
    }
}