using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ReproduceAnim : MonoBehaviour
{
    Animator MyAnimator;
    int isWalkingHash;
    bool any = false;
    // Start is called before the first frame update
    void Start()
    {
        MyAnimator = GetComponent<Animator>();
        isWalkingHash = Animator.StringToHash("isWalking");

    }

    // Update is called once per frame
    void Update()
    {
        bool isWalking = MyAnimator.GetBool(isWalkingHash);
        bool forward = Input.GetKey("w");
        bool backward = Input.GetKey("s");
        bool left = Input.GetKey("a");
        bool right = Input.GetKey("d");
        

        if (!isWalking && any || backward || forward || left || right)
        {
            MyAnimator.SetBool(isWalkingHash, true);
        }
        else
        {
            MyAnimator.SetBool(isWalkingHash, false);
        }
    }
}


