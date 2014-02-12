package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlCourseModules generated by hbm2java
 */
public class MdlCourseModules  implements java.io.Serializable {


     private Long id;
     private long course;
     private long module;
     private long instance;
     private long section;
     private String idnumber;
     private long added;
     private short score;
     private int indent;
     private boolean visible;
     private boolean visibleold;
     private short groupmode;
     private long groupingid;
     private short groupmembersonly;

    public MdlCourseModules() {
    }

	
    public MdlCourseModules(long course, long module, long instance, long section, long added, short score, int indent, boolean visible, boolean visibleold, short groupmode, long groupingid, short groupmembersonly) {
        this.course = course;
        this.module = module;
        this.instance = instance;
        this.section = section;
        this.added = added;
        this.score = score;
        this.indent = indent;
        this.visible = visible;
        this.visibleold = visibleold;
        this.groupmode = groupmode;
        this.groupingid = groupingid;
        this.groupmembersonly = groupmembersonly;
    }
    public MdlCourseModules(long course, long module, long instance, long section, String idnumber, long added, short score, int indent, boolean visible, boolean visibleold, short groupmode, long groupingid, short groupmembersonly) {
       this.course = course;
       this.module = module;
       this.instance = instance;
       this.section = section;
       this.idnumber = idnumber;
       this.added = added;
       this.score = score;
       this.indent = indent;
       this.visible = visible;
       this.visibleold = visibleold;
       this.groupmode = groupmode;
       this.groupingid = groupingid;
       this.groupmembersonly = groupmembersonly;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public long getGroupingid() {
        return groupingid;
    }

    public void setGroupingid(long groupingid) {
        this.groupingid = groupingid;
    }

    public short getGroupmembersonly() {
        return groupmembersonly;
    }

    public void setGroupmembersonly(short groupmembersonly) {
        this.groupmembersonly = groupmembersonly;
    }

    public short getGroupmode() {
        return groupmode;
    }

    public void setGroupmode(short groupmode) {
        this.groupmode = groupmode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public long getInstance() {
        return instance;
    }

    public void setInstance(long instance) {
        this.instance = instance;
    }

    public long getModule() {
        return module;
    }

    public void setModule(long module) {
        this.module = module;
    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public long getSection() {
        return section;
    }

    public void setSection(long section) {
        this.section = section;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisibleold() {
        return visibleold;
    }

    public void setVisibleold(boolean visibleold) {
        this.visibleold = visibleold;
    }
   
   


}


