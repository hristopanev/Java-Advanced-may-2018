package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ModuleContainerTest {

    private AbsorbingModule absorbingModule1;
    private AbsorbingModule absorbingModule2;
    private EnergyModule energyModule1;
    private EnergyModule energyModule2;
    private Container container;


    @Before
    public void before(){
        this.container = new ModuleContainer(3);
        this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        this.energyModule1 = Mockito.mock(EnergyModule.class);
        this.energyModule2 = Mockito.mock(EnergyModule.class);

        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(absorbingModule2.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(2_000_000_000);

        Mockito.when(absorbingModule1.getId()).thenReturn(1);
        Mockito.when(absorbingModule2.getId()).thenReturn(2);
        Mockito.when(energyModule1.getId()).thenReturn(3);
        Mockito.when(energyModule2.getId()).thenReturn(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleException() {
        this.container.addEnergyModule(null);
    }

    @Test
    public void addEnergyModule() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModule() {
        this.container.addAbsorbingModule(null);
    }

    @Test
    public void shouldExceptionEnergyByRemove() {
        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);
        this.container.addEnergyModule(energyModule1);
        this.container.addEnergyModule(energyModule2);


        assertEquals(4000000000L, this.container.getTotalEnergyOutput());
        assertEquals(2000000000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void shouldExceptionAbsorbingByRemove() {
        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);

        assertEquals(4000000000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void shouldEmptyContainerReturnsZero(){
        assertEquals(this.container.getTotalEnergyOutput(), 0);
        assertEquals(this.container.getTotalHeatAbsorbing(), 0);
    }

}