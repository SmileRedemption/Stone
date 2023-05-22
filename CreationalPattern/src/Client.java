public class Client {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new WarriorFactory();
        Character character = characterFactory.createCharacter();
        character.render();

        characterFactory = new MageFactory();
        character = characterFactory.createCharacter();
        character.render();
    }
}

