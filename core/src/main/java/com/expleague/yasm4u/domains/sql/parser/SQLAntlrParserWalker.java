package com.expleague.yasm4u.domains.sql.parser;

import com.expleague.yasm4u.domains.sql.parser.gen.SQLParser;
import com.expleague.yasm4u.domains.sql.parser.gen.SQLParserBaseListener;

import java.util.ArrayList;
import java.util.List;

public class SQLAntlrParserWalker extends SQLParserBaseListener {
    private List<String> tables = new ArrayList<>();

    public List<String> getTables() {
        return tables;
    }

    @Override
    public void enterAtomTableItem(SQLParser.AtomTableItemContext ctx) {
        tables.add(ctx.getText());
    }
}
