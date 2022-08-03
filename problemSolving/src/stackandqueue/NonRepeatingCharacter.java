package stackandqueue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class NonRepeatingCharacter {

    public String solve(String A) {

        String ans = "";
        char[] arr = A.toCharArray();
        if (A.length() == 1) {
            return A;
        } else if (A.length() == 2) {
            if (A.charAt(0) == A.charAt(1)) {
                return arr[0] + "#";
            }
            String ans1 = arr[0] + "";
            ans1 += ans1;
            return ans1;
        }

        Queue<Character> queue = new ArrayDeque<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < arr.length; i++) {
            char arrVal = arr[i];
            if (queue.isEmpty()) {
                queue.add(arrVal);
                map.put(arrVal, map.containsKey(arrVal) ? (map.get(arrVal) + 1) : 1);
            } else if (!queue.isEmpty() && queue.peek() != arrVal) {
                queue.add(arrVal);
                map.put(arrVal, map.containsKey(arrVal) ? (map.get(arrVal) + 1) : 1);
            } else {
                if (!queue.isEmpty() && queue.peek() == arrVal && map.get(queue.peek()) == 1) {
                    queue.poll();
                }
                if (!queue.isEmpty()) {
                    while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                        queue.poll();
                    }
                }
            }
            ans += (!queue.isEmpty() ? (queue.peek() + "") : "#");
        }
        return ans;
    }

    public static void main(String arg[]) {
        NonRepeatingCharacter nonRepeatingCharacter = new NonRepeatingCharacter();
        System.out.println(nonRepeatingCharacter.solve("abadbc"));
        System.out.println(nonRepeatingCharacter.solve("abcabc"));
        System.out.println(nonRepeatingCharacter.solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
        System.out.println(nonRepeatingCharacter.solve("xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr"));
        System.out.println(nonRepeatingCharacter.solve("iliilmbxyeukaymfoljtsonuyagzhpbjopclniiu"));
        System.out.println(nonRepeatingCharacter.solve("snwpikefpowgagwpegkhxqmdesyxcxuwnutzawmmjggxrqzccinmiihtuywzbgkbiujaigqlblqgemfwpkyvleprlvikaenbyqumnhtulpxbfpfhgklrqhfaohzcbrfyvpqzhukikkklntuaobiflyubmfhuzsrxvwgafhfgfkrmyqxzttthcgztgyuivaxxsrenopmpmuvxucyihwjswjfoupzjvkoqozgtcadknibwhrbzuukpuzlbmvmgelmypbojoddkoapdzqhrimzvwddzuprmkiemecorxsnzqnytpozicgsaltwxvpbfrkksyzbntesluxlpgkkejimabghjiuqvvdqwumpywfkvggvxndwoaparwsdkittpkmjfawivapfutjmyghvrhcjlzwuzgnmzlbkgdjbhszfzxuabyidejabdoptqhdrutnvdqzszwnodsmodjcyxcksvllhmmemetcdljqwnymsalzhfdfpgdpizpsekzmdvvvrqhbcjfxgqjllerdfspeejplodhvqbawxtubakjzkehlydgcudbyoxlzwnjublapznjmwonlsfeuetraiwsyloffccpqehzzeasntmqjijsruoxmwpeifqeygkducbbchncqrziwxxpgagfwmgeepjvtucxssekpeyyqeikmzhnnmwypvxirmifqnnxvgkiqxwfmncgahrgygfxptrinwgpffvxjgmeecnfyoovmmvlvdyvqfngtlqlhoyhlorexqhinusxyigfrxmstgrojuadclpyjnnjuphaxkgzjifvzrzzfbiemlbkiroqawboeqbbzidmnktpmicbeqkeksqhmnkifqqugmxvhrfgpugagylltzhxreqepddlnajjqaoilejknebfqxweftgxqslhasyggfttzltbvdpvpuumuhoyukplvcvprhhvapiluujuyxjxcvtunpeisuzikdrnwtuddpawyanoijxcuxvfnyyokzwbovfrqyapsvgdjlikykimhjsamzvhordagmodvthgqdfnycytwkbyywshggerxuvbwpuczmqvvmabxfdptocmmibeskptoeovomjumdpaimxkkqhofzyjsmahnxbuwirdzdukswzugkzpbxilrrjlaucuztlgjovjauacofpylhftrobxoofxrxzgxvzabdspepyjwrmjzljchkbkersudtrtssjjrmnydurphlrsmxxaecmstmtuflcmihobxaaegmujuqxoiearcdeyqbnnpuswldwcsnmmpfmvyfqoxmmxexioscqkpzceqnwytmchsvviejovszfmaibuuwgpyihnxbclcvcqszrqlpaubatalzvrexoxnbbzyxzapucaqjcknnozygosptmurdnapknkmajtbdpzfwkbmxatgiingwtavsnyedjowkqufrsytvjqaxqethbssynalqitkvxhibwxqxvkcbtlxeaefvemicwdonusnqagtgdjcfmetppqycpgrnlqspfpgjjvkhrbgdzipztppbwnikcamgbdxmsgzsnajzestywijthsucgzyxflhefavsgacjgmvrzvynojioaebukpwuarpwfkyplyqhoasqcwhvvvfvcwfyoyktcwihbjtcybhamxuqumwqtazmaupjbyakprzgxvphkdhypkjwghgznhxjuyzwxqvczzaexhyfxttlzetiqkhrjkyfilotncbhllgqvkolrmepvdeieeycusckwrdyxvakbxosyuhgmbfdubtksvydgyjnoonldwmbgrlpmyzuldsvrwbjuwmkjyawdnkreevdsochiocnoxkzasplhhcsvkqvdbezedccvgfmbcaewlygoayacfzzdhcmpgdxbejvkbqprnxcxzzqgmywrydrwhkqbweyfbpgcjmtfhwlrswbjhwlsbdbpsbmciesedfnqdizpsicuzvnncwcfcjqlpehlvkspfpqqnbxzwvnrumakyouvxlsffapbnkiszczragwnjmtmfrzwjbnjjhzqscdzpqrhnhgbifzuaihslynwpmcvtmqqhjsukgclkrcbpvfzigsqkbzgihloivekqbebexlsyhrubyuwwqcjvqvakuipgbecukhvyrrydxikkprkeiguectjvdntozpqfeajrjzkweienneqxaqmsgoadnxasponowafyidmqnvmjszcfzihnqdqrplipdismuowtcakiphrsfgfzrrxnxqdiuaivcymhblqattamomzcgxwbcqftyltzkmzudkqcqhvnmaqfthkwyrydndnhhtmvhehyioglmtfeopnjcwdbhotsjaxzgkfqfhnkxwjmogpjeymqxzwwhwyiucrztiuxfklfiqrmxlkxoeapvykxjlrxjwtyfkuhijlbpqpuuzsdazdsxthqyusxuzzaoeahfudzuzekovtafvshgqydvokcrvafnoicshrgcvpwbonuefmyqknwxbuzpunkawpxoymcgskmodfwsrbatunkxigevtiybwsxgamszbzxulpripqpggrvfqtmfzjioxadvzkrticgdjwemxqvukzgjkbbyqrpdevynmcbhjfvawxqhsvyvwwwlthriaksqojbjgtsvybkruttejkwaflfmwwzayxntvmszgufekmatxbmrvrbiozfvonunvqtusalzsojcxchuduqapgxuhuxvkmafitofykscsihdvxumfdjalzygwaxwafoeorrqseilaanctdsxnljkhejcrmzyfkvkcszecfaqnjrwxbgbgjebtwlcbxelgirzptuavryenxalzfnjrxtouwkcqgszwarpfjhuiybnskcfknlkifwnrgzttzjrwibtgapzjtgtzfmybpqtyxplzxcmdjpwqhvmuyxdkfekyrczkqvsmbsiwnfhjmzhlgubtfwxkymnfpoyxaajnbtkqdiveekagdbikqyfnljmiqfznufmknmnwcwryxuanqfkblccwvearxteicvqzkhffgpymanuvpjbokigfkoikjizckxwsdvfymvugijgewbhxrhpmiloscsxnccezztftetwwsungxqdnpfcjzgqtgxffmhotlvngunbyfcsukrrxmljuwokbvucjwpwukeggdrpspcempeeeklcwzisaaixixvqgfimthtxitykobzdtfodecrkgneuhejohpprbyduwtrwirpbyowldwufnoebzvzuidzykvqfdwgmuhntwmcuvwnlsbqdhxmnbfflbgbefkbcrzhojhcxbkwjrnvnhrthhpvmqbyyuvhqitsfnpejnnsuyksnlvqvrheiknymfshbqbiescguaxrzwnymbnvddoniiiguhjifmxaxmpgydqwycechivtvdclpjnnjbtqxkvtztrdxqtxfktxjssfbokwrtgnywlcetojwarbjvidztcuybhdyalhrjvgzknxatokgnedqobvqcnzvopfmqxdjrpwgxcbcgkdktwrwqwakdrtuwkdgcwbdjccmmnowrvnilevdhtltwycrpcomokjursuaqmkyvbuqidzfmkzvrbqlqfexrgnjluwntdfohzcekhmowkajjpgqajrcytzpawqcrwaetkvlqpsbpheoyyacwxfooyhtlrzzxmbexaazzqplvgqgjixuhbfehbktthbvwtxnfvkomyzucypfisvqijslgynohqntpsoyfjxocfpafocdqqaewbedckigypwwxlnkgfytvhuxpgmbedlefdmoihbrnoeppzsxbvnbdbiqjlfersimqjigkcnzatplbosaxximxjlvbpphxlttqwytqiuajrsuxpbdcwokzkstehlqilqxpulydvwxdkcqtdxckasvdlxjmocpjklqjccewqqyjzamvpdllkqqdqojlulxwiktffrhqcazmyjusrohvkdewrekipygngnwfpmbppezroujcdnsvxqihglqzbhxpfxolliqzxqrwpwjrvdtfqmydmbvaxpisqddsplpfweuvphdfkijgksxbdfommxuqbzraibtdkzppekrobiwzhtmzqglbvgexcghygjhpegcovsikxngjpdsozxxfrmnovlvmhdinjznumzomjouvejdrysmqjxfetlnlhfvdyyotpfjlamsgkzpstvlzktsyfchtcinshuukkrbmeqzksvtdayuleghzgtsqpeiviadfwgagrvmelpjzocfwnujxzknvftddmfkfuogmzocwqqataareazdeyfonmkuefqyssdirwhqirjzoxvjvzjurkfzxqoehqawujjosmcughjxooqfbqhxidewhpdfsfeeclgooxgsqpklhsgdeepxscqyqgnqoecvxrjgmcgyrmetkvugpjoepdxvhbjawyiobqfzlblbchwdwrzwgpqeqkfahptfxzuittckpplktujneltvmuwxflwzekchkdoeotmlztrkjtfinvgvfftntgxujjpeiwwvwrdefwiklvecnpkdgtihdndmnvwcvdgjkylvnpihimmrsdcnesdzhbhcxbodmqgpfqpnvlvrswucujwtvtgyffelqlhchzfdgditzxemrzsddbdmvivaxshligddvwqkhdivdjtusnivlzdyvmfjghszgjrrfwccupkelrzynfpzyqicslttipdztrdrhwqfgktbdgdywhgpvgvlltfouvxolpyltdsqckynctfghozuajepnfkshrkzivnqlqzzyhougbzbbihukrktbgvgtejxqrdndackpbaxcfdvhjuesganchafguggikneneafaybjvfpnppquadgpjjeggxcuuwqnszmehekpjgzbwlumkdxmilmcjnfnspqgdepmspoqwtnowfripbwbjebnqcpavtavavwxpwrxpkoeiyleekgmkmymmfoyxroxdphaexptqicrqjcddkrdgesecgdznsntovhicrfgqjkuvmcgwnikjznizfvecueywoyrjbjnnpvkrjlzoqmnzjmhqydghejwfogzfgseeotnszltnxeuuqlqjzvaxwoamplumvankvypvlekkumwresuvzzdfsanfjvfsuznmvihqwbkqifgabllkgtspuuuszzajtuaefkqzfkcenvcfokdzmelvcewyvhlpgvbxjjrzprwdvonngzabkibzplyxdwapxgzjwkwghsvrjlngbwjszngbvycpinxccywfxzzbvrlnrwadmzuwgapbtbtmpnggoqeqcbiycaanwvlluathydgcmucmovfpqavexjqaknembefbjmvcypvdrodhmfqtbfgvbnjtxenlnhrzgkbjvnirqadnifigmuoyccucgiacylouduwdjqcqhwiranbubnyizswckepagisemgvzxfqrvlopnjzolxdndbxsmmplnryzvkhkohiwmngrptjwicpwwjwivjwcrwayrbaewuqhdxpqfegswkvxiozjmrqrenhifwgxbuugzzhjaalbepuwpsubwnmiuybpdkjkutxikciiliucfkfmogskvfwgnggmydawctoewzpjtjqcwdsbdztgykijkiqcbjgjymkqcjwkitmzwrrgiklkldwysdhyjppgavmvunphhuqjqavhlcxbybxfikyyfrvfklujvcnxxnwbdpzwbpnwjpxjunubbghlkxgbhedmslzikjvzkladxmtvfpzrmydookeidpyfkdffubirsasltccraicnxbdcxafidhbdcumzpnlqqgadqsquabgrpbetvtmtnqqgbeikctzegatpzkbwwkpjytwsdcxeibldtlicpogdluamjjwepivflrizmltvpxrmpgbgehgtbzlcliggpsdzoumdqfegywqqkphlhldoeedaeytxluifynaqnrikmxphfavmbfdktdzprnagribsqgxojfqpadjfgwzwuxkhjdagzrunnrewiyxfowwvxpwtdjjiakcaeeljlbhynnrmstemqqfhzvatqgudqdsdgejmnpbhankgnonmacizilviadhtrnxvymxgasgqqvpwpakmijqhixbebmumzwtknrmeesmkijnxpcmgmmlevdyrnwttlbpstntnrtrmzyniitjenvyrgqovxpxxblkdhdsfscyjwvgnzsksalmzuqkrfaoxjqkeerkmliuhacfzmytkyqqdlaunvoiwjwjzouqpkrqidzxqodndpzfgijffiftjyydszthvtgwgkjtbdjcnkhfglvgjjsqjypmgirvpzqzdwlobctrpklweczwieykjqqgmaqfhiwkgltlxhoeqzghwgqgccpabbnbiwjqnjqekbanspeynkdblmiocnihbodqjbowozqtaghlrobfyybqmdmylerxcchqdyxolgskymxumbkqtmzyautxmbqcnlsixeijpucyaxnbpmxuuyrsdmdeyquszbbzpplsleyvghlxhgoiwtamnccuzwnsvpvnoevjcqqjxigylfxbftfrvfgyimtpsoglosdezshumgpefiauvzmbdrfhrcbawdupdwuyvqzqbumugrnkgkckhtfzfxmkkcxgqgukpfqbtmvrhckhvyqtlcaltedjtegdgoemboaqajxolnjupebkyjuyrcloimrpysaxqxbqxkwbkqnsvbonvmscfuxicaulttagvjuvnzqdurtxfjncetfsdpwzmhmlzvckrkawtzekvdzotmmbbboomgyvaevounhlguwrkkfxxulthlxnbxiwstaiexrdllvjaczlcfwgizrqucmcocpvdzerbuqkgvellirlllzqrigfwoidxtgeprzifdwhczsppebkmugdcnysifoxunpckfjrpfzsrjyvyunphypkqedjxuhmoubghibczxdfpxpvpihzudgtpljmkjsxrjlsxwqenazhzwvxglcymoolrtinovadhvipwugqofozghmlskitikdrkvuioyytchokovehbxhsuschnhivsqtcmkpxlslestztexuexovxlpzpohahdrtklkyarncfotfyacbzpehejcpqjbgqrvqzzquhgwcuempnlevlhucxwonmkpbqejtbvjrjrwiicsvztegngmkjieqjbpchhsixkghjgkemahkffhbooawnlrzozdriwgpzohqaumiaunfgyockjpjsfsabkpyoggudwiozdbcewsgduxnqdwblipzbswmlutcnhhphpktcnptdluvmbrqvpeunciucsmwhqjhiojscmzdewdlqwryzoszzbetnrzvneouduqimtkwtenaxveuxhcgbrzbdxcxnrqnbqqnirugayechhkrzsctwmlyhvepslhytdknzjvtlwypygwfgckzcynqlpjxisyetykcswvzlwrbhauiadbqpxtmuyefctcktknclnzbnsplxfreserdzwhkrwafhcbpqdercpnrpwyytaewpjdmpinlyzdpiddzxshagkiwwathtfpqsshldfirdolrrjnswjmqebxicvxdjdkkgjzejrzrmxiwapeyqvqruzjelhypkaspsmkwlkdtpfprwtdtcsscgykqaafabmshwkwlebumyjztzspgsxqonrewyjvqbslbvlpayotggnamhbxwrqrqaptumhlhzpwvunopkoputvaqhidvuirjbydtzjovlcrlsjpkzfapewglabfgafftargjsreybzwoefjfyhgszmwgcuryiqdsofgmxnawydhaycuuhzmsnbrcjdwasepnstpkobdjsavbdleipmdimygjrzjioyhibwyzkkanvoizmefzrcprstbmfhqrufzqaohomvjomuopungfvjlgnoahnxoynzojcxbajxluahtrrnpavddlolelfpsabdehxftltuysukeidpaggmhpgwwvriyomwirkjubesvuytndwydhmajhppaakuzmwzrpwavzutxxdxxezvzjodooozyujtokchxmqzpartsgfuvgpjtqdocuqqfrgvsddrnlubbozlgsxemwwuzqfpmjgqzjghwubnehopgoejvgzjspzrhpjkybcacegskdehmvvnydckxrihxgiisotdgyebquzazjqesnwtoqlbazcfixzuczllbrxovcircbnhczvtbkfvvepgtljvjubbfybzlmzqrxsihcazipimppvmezrfjtsgpvkrehkivbuqkipdpuzfdwmgyxoeqzcwwtvszmdwekvkmfcytojwhpbyzdsfcimffoqtjjgxkvsikqxalyrkcrcexphcrvyghhxkefrchcbtbsjdnhczfzspjgerulygnrdjbrxoxuevojkitqzdzggegmwjvcctkzqmdyczdodrhsxqscleuhuvuyeoelojwosbzixeuvigzqkbhrmytlzwgnjdliduzvufdofkqtfzofdoyziqszqfmpilmldfcliuankqaggtjobmllwphhluoijoqqccjicuskiczsmiaijnllnarpkayuwowahwacwoyhkswdmfvqbufmyrpqmsialucyowknyymcxwystdqwitpmdbdfoqrtjgmneobgtzuhhacabeyjgnhopvwwlexidjxmxwtilitygdrzviajixleslxicbpzyftivtjrnnrkycwtlmunybpsyhgsupkzyqwokqebcdhqwaqtyrbdhxcjmewlhkjhsedwruzcfbydrqvverdzkvrawmveaqpxhdkzwtxkhlwualeonifpjdfkkpfaqsljjmaycgdridvlqkaslcspdvczeswvxydmnxppanvdcydlfkynftfvfqhqxschmpcarpdzervyfrukelwapofhmddbcommtntzjrnpnuvcmkfupfsygwjskzcvlwkysutfhxshoutjrqjloeetfjweieauqaskfydfmmsrtxalpyumuqaiphflegqoefrdlzyiexhcdablxcbkzbvpujpxsmdqhiqsrzcrjjkjrgfzkktzqrwfpnemnuruhkvkwjtuzbmbnpehbnpfbecmnqtsjoxrtvfkalftymldntiebmyviezzjoxgydmuzsbhbyjalquophswwyxqiwafsvaxnwuspnmkulefzxjxwrfsprpcvbqgvmcxudcvgqorzqriqtrmgrtjdfrhlcrimjjgmbjsjxoqjkdnnsmixhwbhprqntkwbcokvqcghlonithezbjqnweldwsvimporhuescajtggkqgdzxseoinfxknxlxmvynoomdfhlqowtjgbqbqxigbimuyivfbxjzlnsxtwgasmxxtxlklrimrsumnqbbhgkbbmhnvluxhaekpttsuuyissfvwcmaqdajecehtxalyifsowlnzznyfpwifdqwkpdfxiyeopivbjlrguxtgsmopahdcfnjsygllncarxybiczxofpvoybomlgitswukoayuxjcxcscdhmflewgybpspmxsikaxshrnyofhvpafspopjvgwghwvgqkklhcvfsvzgegikznzaqlqcrmbvlnmkejtdeuybmseiimoraeoierjlbigheuwdxekwwdinvcamgztqnpruqerdnvvhymnjkhzxunqhniduptpstsinokzceffhkhndgefwbsmuuxuxjxjuvmqolredhelzbomhuxjdumngaiuyknoakdefwhkfbnhcteqgkpvuznvpodlwlcivnchncsimbhukrosqequwvhrqccssjzzardauuqpnqwrnfwukwgimwxhbbiglueddwwogqhrtcpizkjanrdnucbfrxekhgfbuvoduoxwctdkdgmrszvnliqiqqbdsyewofkfwxcsjtpbdbmxmousgpreelpvqfarenw"));
    }
}