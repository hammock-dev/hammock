/*
 * Class represents results obtained by running hmmsearch
 */
package cz.krejciadam.hammock;

/**
 *
 * @author Adam Krejci
 */
public class HmmsearchSequenceHit implements Comparable<HmmsearchSequenceHit> {

    private final Cluster cluster;
    private final UniqueSequence sequence;
    private final Double score;
    private final Double evalue;

    public HmmsearchSequenceHit(Cluster cluster, UniqueSequence sequence, Double score) {
        this.cluster = cluster;
        this.sequence = sequence;
        this.score = score;
        this.evalue = null;
    }

    public HmmsearchSequenceHit(Cluster cluster, UniqueSequence sequence, Double score, Double evalue) {
        this.cluster = cluster;
        this.sequence = sequence;
        this.score = score;
        this.evalue = evalue;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public UniqueSequence getSequence() {
        return sequence;
    }

    public Double getScore() {
        return score;
    }
    
    public Double getEvalue() {
        return evalue;
    }

    @Override
    public int compareTo(HmmsearchSequenceHit o) {
        if ((this.getScore() - o.getScore()) > 0) {
            return 1;
        }
        if ((this.getScore() - o.getScore()) < 0) {
            return -1;
        }
        int seqDiff = this.getSequence().compareTo(o.getSequence()); //just in case we compared hits with different sequences, which we don't do.
        if (seqDiff != 0) {
            return seqDiff;
        }
        return this.getCluster().compareTo(o.getCluster());

    }

}
