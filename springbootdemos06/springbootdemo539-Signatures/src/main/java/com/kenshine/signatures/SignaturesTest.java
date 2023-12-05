package com.kenshine.signatures;

import org.junit.Assert;
import org.junit.Test;
import signature.AbstractVertexSignature;
import signature.ColoredTree;
import signature.DAG;
import signature.chemistry.AtomPermutor;
import signature.chemistry.Molecule;
import signature.chemistry.MoleculeSignature;
import signature.simple.SimpleGraph;
import signature.simple.SimpleGraphSignature;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname SignaturesTest
 * @Description 简单使用测试
 * @Date 2023-12-05 10:54
 * @modified By：
 * @version: 1.0$
 */
public class SignaturesTest {

    /**
     * AbstractVertexSignature 从图的顶点创建签名
     */
    @Test
    public void test01(){
        String sig = "[A]([B])";
        // AbstractVertexSignature 从图的顶点创建签名
        ColoredTree tree = AbstractVertexSignature.parse(sig);
        System.out.println(tree.toString());
    }

    /**
     * DAG 有向无环图，核心数据结构
     */
    @Test
    public void test02(){
        // C12CC1C1
        DAG ring = new DAG(0, 4);
        DAG.Node root = ring.getRoot();

        DAG.Node child1 = ring.makeNodeInLayer(1, 1);
        ring.addRelation(child1, root);

        DAG.Node child2 = ring.makeNodeInLayer(2, 1);
        ring.addRelation(child2, root);

        DAG.Node child3 = ring.makeNodeInLayer(3, 1);
        ring.addRelation(child3, root);

        DAG.Node child4 = ring.makeNodeInLayer(3, 2);
        ring.addRelation(child4, child1);
        ring.addRelation(child4, child2);

        DAG.Node child5 = ring.makeNodeInLayer(1, 2);
        ring.addRelation(child5, child3);

        DAG.Node child6 = ring.makeNodeInLayer(2, 2);
        ring.addRelation(child6, child3);

        System.out.println(ring);
    }

    /**
     * 分子重排列
     */
    @Test
    public void test03(){
        Molecule molecule = new Molecule();
        molecule.addAtom("O");
        molecule.addAtom("C");
        molecule.addAtom("C");
        molecule.addAtom("C");
        molecule.addAtom("S");
        molecule.addAtom("C");
        // 添加化学键 O=C
        molecule.addBond(0, 1, Molecule.BondOrder.DOUBLE);
        molecule.addSingleBond(1, 2);
        molecule.addSingleBond(2, 3);
        molecule.addSingleBond(3, 4);
        molecule.addSingleBond(4, 5);
        permuteCompletely(molecule);
    }

    /**
     * 简单图形
     */
    @Test
    public void test04(){
        String chain = "0:1,1:2,2:3,3:4";
        SimpleGraphSignature signature = signatureFromString(chain);
        String uncanonizedString = signature.toCanonicalString();
        String maxSignature = signature.getMaximalSignature();

        System.out.println(uncanonizedString);
        System.out.println(maxSignature);
    }

    /**
     * 芳香键测试 笨环结构
     */
    @Test
    public void test05(){
        Molecule benzene = new Molecule();
        benzene.addMultipleAtoms(6, "C");
        // 芳香键关联，笨环结构
        benzene.addBond(0, 1, Molecule.BondOrder.AROMATIC);
        benzene.addBond(1, 2, Molecule.BondOrder.AROMATIC);
        benzene.addBond(2, 3, Molecule.BondOrder.AROMATIC);
        benzene.addBond(3, 4, Molecule.BondOrder.AROMATIC);
        benzene.addBond(4, 5, Molecule.BondOrder.AROMATIC);
        benzene.addBond(5, 0, Molecule.BondOrder.AROMATIC);
        MoleculeSignature molSig = new MoleculeSignature(benzene);
        System.out.println(molSig.toCanonicalString());
    }


    public SimpleGraphSignature signatureFromString(String string) {
        SimpleGraph graph = new SimpleGraph(string);
        return new SimpleGraphSignature(graph);
    }

    /**
     * 分子重排列
     */
    public void permuteCompletely(Molecule molecule) {
        String signature = new MoleculeSignature(molecule).getMolecularSignature();
        printIdentity(molecule, signature);

        AtomPermutor permutor = new AtomPermutor(molecule);
        while (permutor.hasNext()) {
            Molecule permutedMolecule = permutor.next();
            String permutedSignature =
                    new MoleculeSignature(permutedMolecule).getMolecularSignature();
            System.out.println(permutedMolecule
                    + "\t" + Arrays.toString(permutor.getCurrentPermutation())
                    + "\t" + permutedSignature
                    + "\t" + signature.equals(permutedSignature));
            Assert.assertEquals(signature, permutedSignature);
        }
    }

    public void printIdentity(Molecule molecule, String signature) {
        int[] identity = new int[molecule.getAtomCount()];
        for (int i = 0; i < molecule.getAtomCount(); i++) { identity[i] = i; }
        System.out.println(molecule + "\t"
                + Arrays.toString(identity) + "\t" + signature);
    }
}
