package com.expleague.yasm4u.domains.sql.parser;

import com.expleague.yasm4u.domains.sql.parser.gen.SQLParser;
import com.expleague.yasm4u.domains.sql.parser.gen.SQLParserBaseListener;

import java.util.*;

public class SQLAntlrParserWalker extends SQLParserBaseListener {
    private List<String> tables = new ArrayList<>();
    private Set<String> selectedColumns = new HashSet<>();
    private Map<String, List<String>> predicateMap = new HashMap<>();

    public List<String> getTables() {
        return new ArrayList<>(tables);
    }

    public Set<String> getSelectedColumns() {
        return new HashSet<>(selectedColumns);
    }

    public Map<String, List<String>> getColumnPredicates() {
        return new HashMap<>(predicateMap);
    }

    @Override
    public void enterAtomTableItem(SQLParser.AtomTableItemContext ctx) {
        tables.add(ctx.getText());
    }

    @Override
    public void enterSelectColumnElement(SQLParser.SelectColumnElementContext ctx) {
        selectedColumns.add(ctx.getText());
    }

    @Override
    public void enterBinaryComparasionPredicate(SQLParser.BinaryComparasionPredicateContext ctx) {

    }
}
