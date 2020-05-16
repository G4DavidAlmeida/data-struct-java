package app;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> myList = new LinkedList<>();

        myList.add(25);
        myList.add(3);
        myList.add(13);
        myList.add(2);
        myList.add(5);

        System.out.println("lista vazia: " + myList.isEmpty());

        System.out.println("Primeiro elemento: " + myList.peekFirts());
        System.out.println("Ultimo elemento: " + myList.peekLast());

        System.out.println("============================================");

        System.out.println("Elemento removido: " + myList.removeFirst());
        
        System.out.println("Primeiro elemento: " + myList.peekFirts());
        System.out.println("Ultimo elemento: " + myList.peekLast());

        System.out.println("============================================");

        System.out.println("Elemento removido: " + myList.removeLast());
        
        System.out.println("Primeiro elemento: " + myList.peekFirts());
        System.out.println("Ultimo elemento: " + myList.peekLast());

        System.out.println("============================================");

        System.out.println("Elemento removido: " + myList.remove(2));
        
        System.out.println("Primeiro elemento: " + myList.peekFirts());
        System.out.println("Ultimo elemento: " + myList.peekLast());

        System.out.println("============================================");

        System.out.println("Elemento removido: " + myList.remove(50));
        
        System.out.println("Primeiro elemento: " + myList.peekFirts());
        System.out.println("Ultimo elemento: " + myList.peekLast());

        System.out.println("============================================");
        

        myList.clear();

        System.out.println("Limpando lista");
        System.out.println("lista vazia: " + myList.isEmpty());

    }
}