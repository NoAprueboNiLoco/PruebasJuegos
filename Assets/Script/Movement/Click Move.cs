using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using UnityEngine;
using UnityEngine.AI;

public class ClickMove : MonoBehaviour
{
    public NavMeshAgent agent;
    public Animator anim;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        Ray movePosition = Camera.main.ScreenPointToRay(Input.mousePosition);
        UnityEngine.Debug.Log(agent.acceleration);
        if(Input.GetMouseButtonDown(1)){
            
            if(Physics.Raycast(movePosition, out var hitInfo)){
                agent.SetDestination(hitInfo.point);
                anim.SetBool("isWalking",true);
            }
        }
        if(agent.remainingDistance <= 0.01f && agent.remainingDistance > 0f){
                anim.SetBool("isWalking",false);
                UnityEngine.Debug.Log(agent.isStopped);
        }
    }
}
