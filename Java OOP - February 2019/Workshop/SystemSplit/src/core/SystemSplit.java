package core;

import hardwareComponent.Hardware;
import softwareComponent.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class SystemSplit {
    private Map<String, Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardware(Hardware hardware) {
        this.hardwareComponents.putIfAbsent(hardware.getName(), hardware);
    }

    public void addSoftwareComponent(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).addSoftware(software);
        }
    }

    public void releaseSoftwareComponent(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).releaseSoftware(softwareName);
        }
    }

    public String analyze() {

        int softwareComponentCount = 0;
        int memoryInUse = 0;
        int memoryTotal = 0;
        int capacityInUse = 0;
        int capacityTotal = 0;

        for (String name : this.hardwareComponents.keySet()) {
            softwareComponentCount += this.hardwareComponents.get(name).getSoftwareComponentCount();

            memoryInUse += this.hardwareComponents.get(name).getUsedMemory();
            memoryTotal += this.hardwareComponents.get(name).getMaxMemory();
            capacityInUse += this.hardwareComponents.get(name).getUsedCapacity();
            capacityTotal += this.hardwareComponents.get(name).getMaxCapacity();
        }

        StringBuilder sb = new StringBuilder("System Analysis");
        sb.append(System.lineSeparator())
                .append("Hardware Components: ").append(this.hardwareComponents.size())
                .append(System.lineSeparator())
                .append("Software Components: ").append(softwareComponentCount)
                .append(System.lineSeparator())
                .append("Total Operational Memory: ").append(memoryInUse).append(" / ").append(memoryTotal)
                .append(System.lineSeparator())
                .append("Total Capacity Taken: ").append(capacityInUse).append(" / ").append(capacityTotal);

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Power"))
                .forEach(e -> {
                    sb
                            .append(e.getValue().toString())
                            .append(System.lineSeparator());
                });

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Heavy"))
                .forEach(e -> {
                    sb
                            .append(e.getValue().toString())
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
