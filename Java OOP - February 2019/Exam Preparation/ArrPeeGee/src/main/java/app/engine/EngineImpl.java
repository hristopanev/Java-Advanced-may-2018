package app.engine;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;
import app.constants.InputCommands;
import app.constants.Texts;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Writer writer;
    private Reader reader;
    private Battlefield battleField;

    public EngineImpl(Writer writer, Reader reader, Battlefield battleField) {
        this.writer = writer;
        this.reader = reader;
        this.battleField = battleField;
    }

    @Override
    public void run() throws IOException {

        String line = reader.readLine();

        while (!InputCommands.TERMINATE_COMMAND.equals(line)) {
            String[] lineTokens = line.split(Texts.COMMAND_SPLITTER);

            switch (lineTokens[0].toLowerCase()) {
                case InputCommands.CREATE_PARTICIPANT:
                         battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case InputCommands.CREATE_ACTION:
                          battleField.createAction(lineTokens[1],
                    Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                            Arrays.stream(lineTokens).skip(2).toArray().length,
                            String[].class));
                    break;
                case InputCommands.CREATE_SPECIAL:
                    //TODO
                    break;
                case InputCommands.STAT_ACTIONS:
                    //TODO
                    break;
                case InputCommands.STAT_PARTICIPANTS:
                    //TODO
                    break;
                default:
                    this.writer.writeLine(InputCommands.INVALID_COMMAND);
                    break;
            }

            line = reader.readLine();
        }
    }
}
