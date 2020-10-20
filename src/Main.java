public class Main {

    public static void main(String[] args) {
	int size=3;
	if(args.length > 0){
		size = Integer.parseInt(args[0]);
	}
	new MainWindow();

	//new TicTacToe(size);
    }
}
