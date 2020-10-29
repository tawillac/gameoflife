package de.twi.gameOfLife.game.rules;

public enum RuleType {

    OVERPOPULATION(new Overpopulation()),
    UNDERPOPULATION(new Underpopulation()),
    SURVIVE(new Survive()),
    REPRODUCTION(new Reproduction());

    private Rule rule;
    private RuleType (Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
