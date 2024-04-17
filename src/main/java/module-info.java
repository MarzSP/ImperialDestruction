module AlienDestruction {
    requires hanyaeger;
    exports AlienDestruction;
    exports AlienDestruction.Buttons;
    exports AlienDestruction.Scenes;
    exports AlienDestruction.Entities.MenuBar;

    opens audio;
    opens backgrounds;
    opens sprites;

}