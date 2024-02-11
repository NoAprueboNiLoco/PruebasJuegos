using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class WeaponController : MonoBehaviour
{
    public GameObject Axe;
    public bool canAttack = true;
    public float AttackCooldown = 1.0f;
    public bool isAttacking = false;
    
        // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetMouseButtonDown(0))
        {
            if(canAttack)
            {
            AxeAttack();
            }
        }
    }

    public void AxeAttack(){
        isAttacking = true;
        canAttack = false;
        Animator anim = Axe.GetComponent<Animator>();
        anim.SetTrigger("Attack");
        StartCoroutine(resetAttackCooldown());
    }

    IEnumerator resetAttackCooldown(){
        StartCoroutine(ResetAttackBool());
        yield return new WaitForSeconds(AttackCooldown);
        canAttack = true;
    }

    IEnumerator ResetAttackBool(){
        yield return new WaitForSeconds(0.5f);
        isAttacking = false;
    }
}
