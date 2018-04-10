import controller.WordsController;
import dao.TextRepository;
import model.dto.Text;

public class Run {
    public static void main(String[] args) {

        Text nonSortedText = WordsController.filter(TextRepository.retriveText());

        System.out.println(nonSortedText);
        System.out.println(WordsController.sortByVowels(nonSortedText));
    }
}
