package logger.models;

import logger.enums.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    public static final ReportLevel REPORT_LEVEL_DEFAULT = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesCount;

    public AppenderImpl(Layout layout){
        this.layout = layout;
        this.reportLevel = AppenderImpl.REPORT_LEVEL_DEFAULT;
        this.messagesCount = 0;
    }


    protected void incrementMessagesCount(){
        ++this.messagesCount;
    }

    public void setReportLevel(ReportLevel reportLevel){
        this.reportLevel = reportLevel;
    }

    @Override
    public abstract void append(String string, String message, ReportLevel reportLevel);

    public AppenderImpl(Layout layout, ReportLevel reportLevel){
        this(layout);
        this.reportLevel = reportLevel;
    }

    public Layout getLayout(){
        return this.layout;
    }

    public ReportLevel getReportLevel(){
        return this.reportLevel;
    }


    protected boolean canAppend(ReportLevel reportLevel){
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(), this.reportLevel.toString(), this.messagesCount);
    }
}
