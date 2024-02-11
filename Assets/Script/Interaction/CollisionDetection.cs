using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class CollisionDetection : MonoBehaviour
{
    public WeaponController wp;
    public AudioSource Audio;
    private void OnTriggerEnter(Collider other) {
        if(other.tag == "Goblin" && wp.isAttacking)
        {
            if(other.GetComponent<IA>().enabled){
            other.GetComponent<Animator>().SetBool("isChasing", false);
            other.GetComponent<Animator>().SetTrigger("isHit");
            other.GetComponent<IA>().enabled = false;
            Audio.Play();
            }
            
        }
    }
}
