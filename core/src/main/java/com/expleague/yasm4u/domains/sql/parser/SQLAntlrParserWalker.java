package com.expleague.yasm4u.domains.sql.parser;

import com.expleague.yasm4u.domains.sql.parser.gen.SQLParser;
import com.expleague.yasm4u.domains.sql.parser.gen.SQLParserBaseListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SQLAntlrParserWalker extends SQLParserBaseListener {
    private List<String> tables = new ArrayList<>();
    private Set<String> selectedColumns = new HashSet<>();

    public List<String> getTables() {
        return tables;
    }

    public Set<String> getSelectedColumns() {
        return selectedColumns;
    }

    @Override
    public void enterAtomTableItem(SQLParser.AtomTableItemContext ctx) {
        tables.add(ctx.getText());
    }

    @Override
    public void enterSelectColumnElement(SQLParser.SelectColumnElementContext ctx) {
        selectedColumns.add(ctx.getText());
    }
}
