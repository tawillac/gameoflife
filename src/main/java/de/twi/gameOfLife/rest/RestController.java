package de.twi.gameOfLife.rest;

import de.twi.gameOfLife.game.cell.Cell;
import de.twi.gameOfLife.game.game.Game;
import de.twi.gameOfLife.game.grid.Grid;
import de.twi.gameOfLife.game.ruleApplication.RuleApplicator;
import de.twi.gameOfLife.game.rules.*;
import de.twi.gameOfLife.game.grid.StartPattern;
import de.twi.gameOfLife.game.setup.GridCreator;
import org.apache.tomcat.util.digester.Rules;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5555"})
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    private Game game = null;
    private List<RuleType> rules = new ArrayList<>();
    private StartPattern startPattern = StartPattern.BLINKER;

    @GetMapping("/nextStep")
    public Cell[][] getNextStepGrid() {
        System.out.println("nextStep()");
        if (game == null) {
            startGame();
        }
        game.nextStep();
        return game.getGrid().getCellGrid();
    }

    @GetMapping("/startGame")
    public Cell[][] startGame() {
        System.out.println("startGame()");
        RuleApplicator ruleApplicator = new RuleApplicator(rules);
        this.game = new Game(startPattern.getGrid(), ruleApplicator);
        return game.getGrid().getCellGrid();
    }


    @PutMapping("/setRules")
    public void setRules(@RequestBody RuleType[] rules) {
        System.out.println("setRules: " + rules);
        this.rules.clear();
        for (RuleType ruleType : rules) {
            this.rules.add(ruleType);
            System.out.println("setRules: " + ruleType);
        }
    }

    @PutMapping("/addRule/{rule}")
    public void addRule(@PathVariable RuleType rule) {
        if (!rules.contains(rule)) {
            System.out.println("addRule() - " + rule);
            rules.add(rule);
        } else {
            System.err.println("addRule() - Cannot add " + rule + ", because it already exists.");
        }
    }

    @DeleteMapping("/deleteRule/{rule}")
    public void deleteRule(@PathVariable RuleType rule) {
        if (rules.contains(rule)) {
            System.out.println("deleteRule() - " + rule);
            rules.remove(rule);
        } else {
            System.err.println("deleteRule() - Cannot delete " + rule + ", because it does not exist.");
        }
    }

    @PutMapping("/setPattern/{pattern}")
    public void setPattern(@PathVariable StartPattern pattern) {
        System.out.println("setPattern() " + pattern + " ");
        this.startPattern = pattern;
    }

    @GetMapping("/isGameRunning")
    public boolean isGameRunning() {
        System.out.println("isGameRunning() " + this.game != null);
        return this.game != null;
    }

    @GetMapping("/doesRuleExist/{rule}")
    public boolean doesRuleExist(@PathVariable RuleType ruleType) {
        System.out.println("doesRuleExist() " + ruleType + " -> " + rules.contains(ruleType));
        return rules.contains(ruleType);
    }

    @GetMapping("/getRules")
    public List<RuleType> getRules() {
        System.out.println("getRules()");
        return rules;
    }

    @GetMapping("/getPattern")
    public StartPattern getPattern() {
        System.out.println("getPattern()");
        return startPattern;
    }

    @GetMapping("/getDefaultGrid")
    public Cell[][] getDefaultGrid() {
        System.out.println("getPattern()");
        return new GridCreator().getGridWithSmile().getCellGrid();
    }
}
