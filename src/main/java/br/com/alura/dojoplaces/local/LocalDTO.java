package br.com.alura.dojoplaces.local;

import br.com.alura.dojoplaces.utils.DateUtilities;

public class LocalDTO {
    private long id;
    private String name;
    private String code;
    private String creationDate;
    private long daysSinceLastUpdate;

    public LocalDTO(Local local) {
        this.id = local.getId();
        this.name = local.getName();
        this.code = local.getCode();
        this.creationDate = DateUtilities.formatDateToBrazilianConvention(local.getCreationDate());
        this.daysSinceLastUpdate = DateUtilities.countDaysSince(local.getUpdateDate());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public long getDaysSinceLastUpdate() {
        return daysSinceLastUpdate;
    }

    public void setDaysSinceLastUpdate(long daysSinceLastUpdate) {
        this.daysSinceLastUpdate = daysSinceLastUpdate;
    }
}
